package ru.otus.nosqldb;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongock
@EnableMongoRepositories
@SpringBootApplication
public class S15NoSqlDb {
    public static void main(String[] args) {
        SpringApplication.run(S15NoSqlDb.class, args);
    }
}
