package ru.otus.springconfiguration.domain;

import lombok.Data;

@Data
public class Answer {
    private final String text;

    private final boolean isCorrect;
}
