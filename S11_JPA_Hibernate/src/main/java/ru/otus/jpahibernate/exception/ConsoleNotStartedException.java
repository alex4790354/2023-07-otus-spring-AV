package ru.otus.jpahibernate.exception;

public class ConsoleNotStartedException extends RuntimeException {
    public ConsoleNotStartedException(String message, Throwable cause) {
        super(message, cause);
    }
}
