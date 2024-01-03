package ru.otus.springboot.exception;

public class AppException extends RuntimeException {
    public AppException(Exception e) {
        super(e);
    }
}

