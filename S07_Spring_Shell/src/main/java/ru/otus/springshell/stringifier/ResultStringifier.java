package ru.otus.springshell.stringifier;


import ru.otus.springshell.domain.Result;


public interface ResultStringifier {
    String stringify(Result result, int scoreToPass);

}
