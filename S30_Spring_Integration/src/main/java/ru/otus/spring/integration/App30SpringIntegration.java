package ru.otus.spring.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.retry.annotation.EnableRetry;
import ru.otus.spring.integration.service.FeedService;

@Slf4j
@EnableRetry
@EnableFeignClients
@SpringBootApplication
public class App30SpringIntegration {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(App30SpringIntegration.class, args);

		FeedService orderService = ctx.getBean(FeedService.class);
		orderService.startGenerateOrdersLoop();
	}
}
