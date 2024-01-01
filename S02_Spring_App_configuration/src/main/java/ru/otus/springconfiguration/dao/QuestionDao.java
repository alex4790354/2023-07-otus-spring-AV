package ru.otus.springconfiguration.dao;

import ru.otus.springconfiguration.domain.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> findAll();
}
