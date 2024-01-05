package ru.otus.springjdbc.exception;

public class InvalidDataException extends IllegalArgumentException {

    public InvalidDataException(String message) {
        super(message);
    }
}
