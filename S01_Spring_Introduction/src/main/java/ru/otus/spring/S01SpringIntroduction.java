package ru.otus.spring;


import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.service.TestingServiceImpl;
import ru.otus.spring.service.api.TestingService;

public class S01SpringIntroduction {
    public static void main(String[] args) throws BeansException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        TestingService testingService = context.getBean(TestingServiceImpl.class);
        testingService.executeTesting();
    }
}
