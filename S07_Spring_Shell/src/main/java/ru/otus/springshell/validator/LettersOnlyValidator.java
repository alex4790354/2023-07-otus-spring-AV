package ru.otus.springshell.validator;

public interface LettersOnlyValidator {

    boolean validate(String value);

    String errorMessage();
}
