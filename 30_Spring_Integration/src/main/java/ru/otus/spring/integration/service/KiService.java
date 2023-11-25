package ru.otus.spring.integration.service;


import ru.otus.spring.integration.domain.RateDto;
import ru.otus.spring.integration.domain.xml.ValCurs;

public interface KiService {

    RateDto convert(ValCurs valCurs);

}
