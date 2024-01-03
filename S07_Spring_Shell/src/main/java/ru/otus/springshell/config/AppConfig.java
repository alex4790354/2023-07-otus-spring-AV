package ru.otus.springshell.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@EnableConfigurationProperties(AppProperties.class)
@Configuration
public class AppConfig {
}
