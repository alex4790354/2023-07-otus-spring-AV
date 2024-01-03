package ru.otus.springshell.stringifier;


import ru.otus.springshell.domain.Question;


public interface QuestionStringifier {

    String stringify(Question question);
}
