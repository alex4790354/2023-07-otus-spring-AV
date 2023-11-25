package ru.otus.spring.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.*;
import org.springframework.integration.scheduling.PollerMetadata;
import ru.otus.spring.integration.service.KiService;

@Configuration
public class IntegrationConfig {

	@Bean(name = PollerMetadata.DEFAULT_POLLER)
	public PollerSpec poller() {
		return Pollers.fixedRate(100).maxMessagesPerPoll(2);
	}


//////////////////////////////// cbrChannel  ratesChannel

	@Bean
	public MessageChannelSpec<?, ?> cbrChannel() {
		return MessageChannels.queue(10);
	}

	@Bean
	public MessageChannelSpec<?, ?> ratesChannel() {
		return MessageChannels.publishSubscribe();
	}

	@Bean
	public IntegrationFlow rateFlow(KiService kiService) {
		return IntegrationFlow.from(cbrChannel())
				.split()
				.handle(kiService, "convert")
				//.<Food, Food>transform(f -> new Food(f.getName().toUpperCase()))
				.aggregate()
				.channel(ratesChannel())
				.get();
	}

}
