package ru.otus.springshell.exception;

public class AppException extends RuntimeException {
    public AppException(Exception e) {
        super(e);
    }
}

