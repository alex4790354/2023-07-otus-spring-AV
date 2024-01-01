package ru.otus.springconfiguration;


import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.springconfiguration.controller.TestingAppController;


@PropertySource("classpath:application.properties")
@ComponentScan
@Configuration
public class S02SpringAppConfiguration {
    public static void main(String[] args) throws BeansException {
        var context = new AnnotationConfigApplicationContext(S02SpringAppConfiguration.class);
        var testingAppController = context.getBean(TestingAppController.class);
        testingAppController.executeTesting();
    }
}
