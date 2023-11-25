package ru.otus.spring.integration.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.otus.spring.integration.domain.RateDto;
import ru.otus.spring.integration.domain.xml.ValCurs;

@Service
@Slf4j
public class KiServiceImp implements KiService {

    @Override
    public RateDto convert(ValCurs valCurs) {
        log.info("Convert {} start", valCurs.getDate());
        delay();
        log.info("Cooking {} done", valCurs.getDate());

        return new RateDto("id",
                123,
                "USD",
                1l,
                "USD",
                1.1,
                1.1,
                "2023-11-24");
    }

    private static void delay() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
