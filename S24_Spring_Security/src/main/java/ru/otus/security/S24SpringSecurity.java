package ru.otus.security;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 * To log in, please use the following credentials:
 * <pre>
 *     Username: usr
 *     Password: pwd
 * </pre>
 *
 * Enter these details in the respective fields to access user account.
 */
@SpringBootApplication
public class S24SpringSecurity {
    public static void main(String[] args) {
        SpringApplication.run(S24SpringSecurity.class, args);
    }
}
