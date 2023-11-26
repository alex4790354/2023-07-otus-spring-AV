package ru.otus.spring.integration.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.constant.DateFormatConstant;
import ru.otus.spring.integration.domain.RateDto;
import generated.daily.ValCurs;
import ru.otus.spring.integration.utils.DateHelper;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RatesServiceImp implements RatesService {

    @Override
    public List<RateDto> convert(ValCurs valCurs) {
        log.info("Convert {} start", valCurs.getDate());

        List<RateDto> currencyRateDtoList = new ArrayList<>();
        RateDto currencyRateDto;
        for (ValCurs.Valute item : valCurs.getValute()) {
            currencyRateDto = new RateDto(item.getID(),
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
            currencyRateDtoList.add(currencyRateDto);
        }

        delay();
        log.info("Convert {} done", valCurs.getDate());
        return currencyRateDtoList;
    }

    private static void delay() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
