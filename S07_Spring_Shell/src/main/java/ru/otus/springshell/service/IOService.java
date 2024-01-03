package ru.otus.springshell.service;

public interface IOService {
    void output(String message);

    String readLn(String prompt);

    int readInt(String prompt);
}
