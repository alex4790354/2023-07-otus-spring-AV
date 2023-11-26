package ru.otus.spring.integration.service;


import generated.daily.ValCurs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.constant.DateFormatConstant;
import ru.otus.spring.integration.domain.RateDto;
import ru.otus.spring.integration.repository.ReceiverCbrRepository;
import ru.otus.spring.integration.utils.DateHelper;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RatesServiceImp implements RatesService {

    private final ReceiverCbrRepository receiverCbrRepository;

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

    @Override
    public void saveToDb(RateDto rateDto) {
        receiverCbrRepository.saveRateWithHistory(rateDto);
    }

    private static void delay() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
