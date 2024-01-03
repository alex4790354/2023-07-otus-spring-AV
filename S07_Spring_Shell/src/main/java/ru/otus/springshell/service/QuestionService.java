package ru.otus.springshell.service;

import ru.otus.springshell.domain.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions();
}
