package ru.otus.springshell;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class S05SpringShell {
    public static void main(String[] args) throws BeansException {
        SpringApplication.run(S05SpringShell.class, args);
    }
}
