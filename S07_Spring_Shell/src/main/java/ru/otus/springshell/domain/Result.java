package ru.otus.springshell.domain;


import lombok.Data;

@Data
public class Result {

    private final User user;

    private int total;

    private int correctAnswers;

    public void incrementCorrectAnswers(boolean mustIncremented) {
        total++;
        if (mustIncremented) {
            correctAnswers++;
        }
    }
}
