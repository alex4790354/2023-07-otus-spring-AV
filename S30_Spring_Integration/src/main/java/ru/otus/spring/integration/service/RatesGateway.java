package ru.otus.spring.integration.service;


import generated.daily.ValCurs;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.otus.spring.integration.domain.CurrencyRateDto;

import java.util.Collection;

@MessagingGateway
public interface RatesGateway {

	@Gateway(requestChannel = "cbrChannel", replyChannel = "ratesChannel")
	Collection<CurrencyRateDto> process(ValCurs valCurs);
}
