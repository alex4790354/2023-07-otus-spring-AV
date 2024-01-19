package ru.otus.springshell;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class S07SpringShell {
    public static void main(String[] args) throws BeansException {
        SpringApplication.run(S07SpringShell.class, args);
    }
}
