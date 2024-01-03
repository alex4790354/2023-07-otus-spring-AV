package ru.otus.springshell.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.springshell.service.LocalizationMessageService;
import ru.otus.springshell.service.impl.IOStreamsService;
import ru.otus.springshell.service.IOService;


@Configuration
@RequiredArgsConstructor
public class IOServiceConfig {

    private final LocalizationMessageService messageService;

    @Bean
    public IOService ioService() {
        return new IOStreamsService(System.out, System.in, messageService);
    }
}
