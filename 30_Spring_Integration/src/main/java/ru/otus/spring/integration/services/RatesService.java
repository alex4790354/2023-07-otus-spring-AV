package ru.otus.spring.integration.services;


import ru.otus.spring.integration.domain.RateDto;
import ru.otus.spring.integration.domain.xml.ValCurs;

public interface RatesService {

    RateDto convert(ValCurs valCurs);

}
