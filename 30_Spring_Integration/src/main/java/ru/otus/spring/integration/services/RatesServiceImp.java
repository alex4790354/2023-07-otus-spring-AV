package ru.otus.spring.integration.services;


import ru.otus.spring.integration.domain.RateDto;
import ru.otus.spring.integration.domain.xml.ValCurs;

public class RatesServiceImp implements RatesService {

    @Override
    public RateDto convert(ValCurs valCurs) {
        return new RateDto("id",
                123,
                "USD",
                1l,
                "USD",
                1.1,
                1.1,
                "2023-11-24");
    }
}
