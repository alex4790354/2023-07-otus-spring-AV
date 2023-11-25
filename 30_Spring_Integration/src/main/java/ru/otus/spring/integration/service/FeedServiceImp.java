package ru.otus.spring.integration.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.controller.feing.FeingClientCbr;
import ru.otus.spring.integration.domain.RateDto;
import ru.otus.spring.integration.domain.xml.ValCurs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeedServiceImp implements FeedService {

    private final RatesGateway gateway;
    private final FeingClientCbr feingClientCbr;

    /*public FeedServiceImp(RatesGateway gateway) {
        this.gateway = gateway;
    }*/

    @Override
    public void startGenerateOrdersLoop() {

        ForkJoinPool pool = ForkJoinPool.commonPool();
        for (int i = 0; i < 10; i++) {
            int num = i + 1;
            pool.execute(() -> {
                ValCurs valCurs = generateValCurs();
                log.info("{}, New ValCurs.getValute().size(): {}", num,
                        //valCurs.getValute().stream().map(ValCurs.Valute::getCharCode).collect(Collectors.joining(","))
                        valCurs.getValute().size()
                        );
                Collection<RateDto> rates = gateway.process(valCurs);
                log.info("{}, Ready food: {}", num, rates.stream()
                        .map(RateDto::getName)
                        .collect(Collectors.joining(",")));
            });
            delay();
        }

    }

    private static ValCurs generateValCurs() {

        List<ValCurs.Valute> valute = new ArrayList<>();

        ValCurs.Valute valuteOne = new ValCurs.Valute();
        valuteOne.setNumCode(1);
        valuteOne.setCharCode("USD");
        valuteOne.setNominal(1L);
        valuteOne.setName("USD");
        valuteOne.setValue("90");
        valuteOne.setVunitRate("90.1");
        valuteOne.setID("ID-1");
        valute.add(valuteOne);

        valuteOne = new ValCurs.Valute();
        valuteOne.setNumCode(2);
        valuteOne.setCharCode("USD");
        valuteOne.setNominal(2L);
        valuteOne.setName("USD");
        valuteOne.setValue("90");
        valuteOne.setVunitRate("90.1");
        valuteOne.setID("ID-2");
        valute.add(valuteOne);

        ValCurs valCurs = new ValCurs();
        valCurs.setDate("15.11.2023");
        valCurs.setName("Foreign Currency Market");
        valCurs.setValute(valute);

        return new ValCurs();
    }

    private void delay() {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
