package ru.otus.springboot.stringifier;


import ru.otus.springboot.domain.Result;


public interface ResultStringifier {
    String stringify(Result result, int scoreToPass);

}
