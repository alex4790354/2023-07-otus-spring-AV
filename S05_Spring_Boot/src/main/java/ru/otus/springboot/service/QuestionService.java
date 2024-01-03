package ru.otus.springboot.service;

import ru.otus.springboot.domain.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions();
}
