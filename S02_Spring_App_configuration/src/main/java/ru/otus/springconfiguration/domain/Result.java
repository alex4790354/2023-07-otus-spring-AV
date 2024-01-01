package ru.otus.springconfiguration.domain;

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
