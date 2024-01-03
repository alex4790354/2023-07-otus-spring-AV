package ru.otus.springboot.dao;

import ru.otus.springboot.domain.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> findAll();
}
