package ru.otus.spring.integration.service;


import generated.daily.ValCurs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.constant.DateFormatConstant;
import ru.otus.spring.integration.domain.CurrencyRateDto;
import ru.otus.spring.integration.utils.DateHelper;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RatesServiceImp implements RatesService {

    CbrLoadDataService cbrLoadDataService;

    @Override
    public List<CurrencyRateDto> convert(ValCurs valCurs) {
        log.info("Convert {} start", valCurs.getDate());

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

        delay();
        log.info("Convert {} done", valCurs.getDate());
        return currencyCurrencyRateDtoList;
    }

    @Override
    public void saveToDb(CurrencyRateDto currencyRateDto) {
        cbrLoadDataService.loadCurrencyRate(currencyRateDto);
    }

    private static void delay() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
