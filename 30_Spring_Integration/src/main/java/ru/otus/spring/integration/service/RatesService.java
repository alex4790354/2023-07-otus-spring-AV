package ru.otus.spring.integration.service;


import ru.otus.spring.integration.domain.RateDto;
import generated.daily.ValCurs;
import java.util.List;


public interface RatesService {

    List<RateDto> convert(ValCurs valCurs);

}
