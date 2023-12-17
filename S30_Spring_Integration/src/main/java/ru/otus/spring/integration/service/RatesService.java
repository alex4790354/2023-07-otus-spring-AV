package ru.otus.spring.integration.service;


import generated.daily.ValCurs;
import ru.otus.spring.integration.domain.CurrencyRateDto;

import java.util.List;


public interface RatesService {

    List<CurrencyRateDto> convert(ValCurs valCurs);

    void saveToDb(CurrencyRateDto currencyRateDto);

}
