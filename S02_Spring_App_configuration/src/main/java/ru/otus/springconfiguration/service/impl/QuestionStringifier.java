package ru.otus.springconfiguration.service.impl;


import org.springframework.stereotype.Component;
import ru.otus.springconfiguration.domain.Question;
import ru.otus.springconfiguration.service.Stringifier;


@Component
public class QuestionStringifier implements Stringifier {

    @Override
    public String stringify(Question question) {
        var builder = new StringBuilder(question.getText() + "\n");
        int optionNumber = 1;
        for (var answer : question.getOptions()) {
            builder
                    .append("   ")
                    .append(optionNumber++)
                    .append(". ")
                    .append(answer.getText())
                    .append("\n");
        }
        return builder.toString();
    }
}

