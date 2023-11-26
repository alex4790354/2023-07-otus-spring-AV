package ru.otus.spring.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.MessageChannelSpec;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.PollerSpec;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.scheduling.PollerMetadata;
import ru.otus.spring.integration.service.RatesService;

@Configuration
public class IntegrationConfig {

	@Bean(name = PollerMetadata.DEFAULT_POLLER)
	public PollerSpec poller() {
		return Pollers.fixedRate(100).maxMessagesPerPoll(2);
	}

	@Bean
	public MessageChannelSpec<?, ?> cbrChannel() {
		return MessageChannels.queue(10);
	}

	@Bean
	public MessageChannelSpec<?, ?> ratesChannel() {
		return MessageChannels.publishSubscribe();
	}

	@Bean
	public IntegrationFlow rateFlow(RatesService ratesService) {
		return IntegrationFlow.from(cbrChannel())
				.split()
				.handle(ratesService, "convert")
				.channel(ratesChannel())
				.get();
	}

}
