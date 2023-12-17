package ru.otus.spring.integration.repository;


import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.OffsetDateTimeTypeHandler;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.integration.domain.CurrencyDto;
import ru.otus.spring.integration.domain.CurrencyRateDto;
import ru.otus.spring.integration.domain.RateDtoDb;
import java.util.List;

@Mapper
@Repository
public interface ReceiverCbrRepository {

    @Insert("""
                <script>
                    INSERT INTO cbr.currency(id, frequency, name_rus, name_eng, nominal, parent_code)
                    VALUES
                        <foreach item='item' collection='currenciesList' open='' separator=',' close=''>
                            (
                                #{item.id},
                                #{item.frequency},
                                #{item.nameRus},
                                #{item.nameEng},
                                #{item.nominal},
                                #{item.parentCode}
                            )
                        </foreach>
                    ON CONFLICT (id)
                        DO
                            UPDATE SET
                                frequency=EXCLUDED.frequency,
                                name_rus=EXCLUDED.name_rus,
                                name_eng=EXCLUDED.name_eng,
                                nominal=EXCLUDED.nominal,
                                parent_code=EXCLUDED.parent_code,
                                update_time=NOW()
                </script>
            """)
    void saveCurrenciesList(@Param("currenciesList") List<CurrencyDto> currenciesList);


    @Transactional
    default void saveRatesListWithHistory(List<CurrencyRateDto> ratesList) {
        for (CurrencyRateDto rate : ratesList) {
            RateDtoDb currentRate = findCurrentRateById(rate.getId());
            if (currentRate == null) {
                insertNewRate(rate);
            }
            else if (rate.getEffectiveDate().isBefore(currentRate.getEffectiveDate())) {
                upsertRateHistory(rate);
            }
            else {
                archiveCurrentRate(currentRate);
                updateCurrentRate(rate);
            }
        }
    }


    default void saveRateWithHistory(CurrencyRateDto rate) {

        RateDtoDb currentRate = findCurrentRateById(rate.getId());
        if (currentRate == null) {
            insertNewRate(rate);
        }
        else if (rate.getEffectiveDate().isBefore(currentRate.getEffectiveDate())) {
            upsertRateHistory(rate);
        }
        else {
            archiveCurrentRate(currentRate);
            updateCurrentRate(rate);
        }

    }


    @Select("SELECT id, effective_date, nominal, first_crncy, second_crncy, value, creation_time FROM cbr.currency_rate WHERE id = #{id}")
    @Result(column = "CREATION_TIME", typeHandler = OffsetDateTimeTypeHandler.class)
    RateDtoDb findCurrentRateById(String id);


    @Insert("""
                INSERT INTO cbr.currency_rate (id, effective_date, nominal, first_crncy, second_crncy, value)
                VALUES (#{rate.id}, TO_DATE(#{rate.dateAsString}, 'YYYY-MM-DD'), #{rate.nominal}, #{rate.charCode}, 'RUB', #{rate.value})
             """)
    void insertNewRate(@Param("rate") CurrencyRateDto rate);


    @Update("""
                UPDATE cbr.currency_rate
                    SET effective_date = #{rate.effectiveDate},
                        value = #{rate.value},
                        nominal = #{rate.nominal},
                        first_crncy = #{rate.charCode},
                        update_time = NOW()
                WHERE id = #{rate.id}
            """)
    void updateCurrentRate(@Param("rate") CurrencyRateDto rate);


    @Insert("""
            INSERT INTO cbr.currency_rate_history (id, effective_date, nominal, first_crncy, second_crncy, value, creation_time, archived_at)
            VALUES (#{rate.id}, TO_DATE(#{rate.dateAsString}, 'YYYY-MM-DD'), #{rate.nominal}, #{rate.charCode}, 'RUB', #{rate.value}, now(), now())
            ON CONFLICT (id, effective_date)
                DO
                UPDATE SET
                    value = EXCLUDED.value,
                    archived_at = NOW()
            """)
    void upsertRateHistory(@Param("rate") CurrencyRateDto rate);


    @Insert("""
                INSERT INTO cbr.currency_rate_history (id, effective_date, nominal, first_crncy, second_crncy, value, creation_time, archived_at)
                VALUES (#{rate.id}, #{rate.effectiveDate}, #{rate.nominal}, #{rate.firstCrncy}, #{rate.secondCrncy}, #{rate.value}, #{rate.creationTime}, NOW())
                ON CONFLICT (id, effective_date)
                    DO
                    UPDATE SET
                        nominal = EXCLUDED.nominal,
                        first_crncy = EXCLUDED.first_crncy,
                        second_crncy = EXCLUDED.second_crncy,
                        value = EXCLUDED.value,
                        archived_at = NOW()
            """)
    void archiveCurrentRate(@Param("rate") RateDtoDb rate);

}
