package ru.otus.springboot.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.springboot.service.LocalizationMessageService;
import ru.otus.springboot.service.impl.IOStreamsService;
import ru.otus.springboot.service.IOService;


@Configuration
@RequiredArgsConstructor
public class IOServiceConfig {

    private final LocalizationMessageService messageService;

    @Bean
    public IOService ioService() {
        return new IOStreamsService(System.out, System.in, messageService);
    }
}
