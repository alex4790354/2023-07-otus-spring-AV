package ru.otus.springconfiguration.exception;

public class AppException extends RuntimeException {
    public AppException(Exception e) {
        super(e);
    }
}

