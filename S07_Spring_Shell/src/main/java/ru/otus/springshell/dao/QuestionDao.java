package ru.otus.springshell.dao;

import ru.otus.springshell.domain.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> findAll();
}
