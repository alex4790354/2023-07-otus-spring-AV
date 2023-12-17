package ru.otus.spring.integration.service;


import generated.daily.ValCurs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.constant.DateFormatConstant;
import ru.otus.spring.integration.controller.FeingClientCbr;
import ru.otus.spring.integration.domain.CurrencyRateDto;
import ru.otus.spring.integration.utils.DateHelper;
import java.util.Collection;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeedServiceImp implements FeedService {

    private final RatesGateway gateway;

    private final FeingClientCbr feingClientCbr;

    @Override
    public void startGenerateOrdersLoop() {

        ForkJoinPool pool = ForkJoinPool.commonPool();
        for (int i = 0; i < 8; i++) {
            String vRequestDateAsString = new DateHelper().getTodateDateAsString(DateFormatConstant.CBR_REQUEST.getValue(), i);
            int num = i + 1;
            pool.execute(() -> {
                ResponseEntity<ValCurs> valCursResponseEntity = feingClientCbr.feinGetRatesOnDate(vRequestDateAsString);
                ValCurs valCursDailyResult = valCursResponseEntity.getBody();

                log.info("{}, New ValCurs.getValute().size(): {}", num,
                        valCursDailyResult.getValute().size()
                        );
                Collection<CurrencyRateDto> rates = gateway.process(valCursDailyResult);
                log.info("{}, Ready rates: {}", num, rates.stream()
                        .map(CurrencyRateDto::getName)
                        .collect(Collectors.joining(",")));
            });
            delay();
        }

    }

    private void delay() {
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
