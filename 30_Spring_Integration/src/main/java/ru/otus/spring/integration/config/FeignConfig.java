package ru.otus.spring.integration.config;


import feign.Retryer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class FeignConfig {

    @Value("${feign.period-seconds}")
    private Integer periodSeconds;

    @Value("${feign.maxPeriod-seconds}")
    private Integer maxPeriodSeconds;

    @Value("${feign.maxAttempts}")
    private Integer maxAttempts;


    @Bean
    public Retryer retryer() {
        return new Retryer.Default(
                TimeUnit.SECONDS.toSeconds(periodSeconds),
                TimeUnit.SECONDS.toSeconds(maxPeriodSeconds),
                maxAttempts);
    }
}
