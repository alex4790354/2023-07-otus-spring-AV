package ru.otus.spring.utils;


import ru.otus.spring.domain.Question;
import ru.otus.spring.domain.Answer;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionsStringifier implements Stringifier<Question> {
    @Override
    public List<String> stringify(List<Question> questionWithOptions) {
        return questionWithOptions.stream().map(this::stringify).toList();
    }

    @Override
    public String stringify(Question question) {
        String questionText = question.getText();
        var options = question.getOptions().stream().map(Answer::getText)
                .map(s -> " " + s)
                .collect(Collectors.joining("\n"));
        return "\n" + questionText + "\n" + options;
    }

}
