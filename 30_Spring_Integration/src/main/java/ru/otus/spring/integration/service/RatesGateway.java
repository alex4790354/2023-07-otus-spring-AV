package ru.otus.spring.integration.service;


import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.otus.spring.integration.domain.RateDto;
import ru.otus.spring.integration.domain.xml.ValCurs;

import java.util.Collection;

@MessagingGateway
public interface RatesGateway {

	@Gateway(requestChannel = "cbrChannel", replyChannel = "ratesChannel")
	Collection<RateDto> process(ValCurs valCurs);
}
