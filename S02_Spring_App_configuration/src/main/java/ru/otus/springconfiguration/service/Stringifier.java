package ru.otus.springconfiguration.service;


import ru.otus.springconfiguration.domain.Question;
import ru.otus.springconfiguration.domain.Result;


public interface Stringifier {

    default String stringify(Question question) {
        return null;
    }

    default String stringify(Result result, int scoreToPass) {
        return null;
    }
}
