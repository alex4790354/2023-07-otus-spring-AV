package ru.otus.spring.integration.service;


import generated.daily.ValCurs;
import ru.otus.spring.integration.domain.RateDto;

import java.util.List;


public interface RatesService {

    List<RateDto> convert(ValCurs valCurs);

}
