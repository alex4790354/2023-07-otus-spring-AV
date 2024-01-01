package ru.otus.springconfiguration.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.springconfiguration.service.impl.IOStreamsService;
import ru.otus.springconfiguration.service.IOService;

@Configuration
public class AppConfig {

    @Bean
    public IOService ioService() {
        return new IOStreamsService(System.out, System.in);
    }
}
