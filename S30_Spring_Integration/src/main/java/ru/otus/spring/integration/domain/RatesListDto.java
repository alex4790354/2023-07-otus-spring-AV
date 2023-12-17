package ru.otus.spring.integration.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import generated.daily.ValCurs;
import lombok.Data;
import ru.otus.spring.integration.constant.DateFormatConstant;
import ru.otus.spring.integration.utils.DateHelper;
import java.util.ArrayList;
import java.util.List;

@Data
public class RatesListDto {


    @JsonProperty("Foreign CurrencyDto Market Lib")
    private List<CurrencyRateDto> currencyRateList;

    public void setRatesFromDailyRateList(ValCurs valCurs) {
        List<CurrencyRateDto> currencyCurrencyRateDtoList = new ArrayList<>();
        CurrencyRateDto currencyRateDto;
        for (ValCurs.Valute item : valCurs.getValute()) {
            currencyRateDto = new CurrencyRateDto(item.getID(),
                    item.getNumCode(),
                    item.getCharCode(),
                    item.getNominal(),
                    item.getName(),
                    Double.parseDouble(item.getValue().replace(",", ".")),
                    Double.parseDouble(item.getVunitRate().replace(",", ".")),
                    new DateHelper().getNewDateAsString(valCurs.getDate(),
                                                        DateFormatConstant.CBR_RESPONSE.getValue(),
                                                        DateFormatConstant.SPIMEX_DB.getValue())
            );
            currencyCurrencyRateDtoList.add(currencyRateDto);
        }
        currencyRateList = currencyCurrencyRateDtoList;
    }

}
