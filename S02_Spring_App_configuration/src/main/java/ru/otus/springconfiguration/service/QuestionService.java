package ru.otus.springconfiguration.service;

import ru.otus.springconfiguration.domain.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions();
}
