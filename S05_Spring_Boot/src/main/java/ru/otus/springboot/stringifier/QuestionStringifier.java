package ru.otus.springboot.stringifier;


import ru.otus.springboot.domain.Question;


public interface QuestionStringifier {

    String stringify(Question question);
}
