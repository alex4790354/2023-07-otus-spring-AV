package ru.otus.webflux;


import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;


@EnableMongock
@EnableReactiveMongoRepositories
@SpringBootApplication
public class S22WebFlux {
    public static void main(String[] args) {
        SpringApplication.run(S22WebFlux.class, args);
    }
}
