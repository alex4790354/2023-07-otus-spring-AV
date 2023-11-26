package ru.otus.spring.integration.service;


import ru.otus.spring.integration.domain.RateDto;
import ru.otus.spring.integration.domain.xml.ValCurs;
import java.util.Collection;


public interface RatesService {

    Collection<RateDto> convert(ValCurs valCurs);

}
