package ru.otus.spring.integration.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.otus.spring.integration.constant.DateFormatConstant;
import ru.otus.spring.integration.domain.xml.ValCurs;
import ru.otus.spring.integration.utils.DateHelper;

import java.util.ArrayList;
import java.util.List;

@Data
public class RatesListDto {


    @JsonProperty("Foreign CurrencyDto Market Lib")
    protected List<RateDto> currencyRateList;

    public void setRatesFromDailyRateList(ValCurs valCurs) {
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
        currencyRateList = currencyRateDtoList;
    }


}
