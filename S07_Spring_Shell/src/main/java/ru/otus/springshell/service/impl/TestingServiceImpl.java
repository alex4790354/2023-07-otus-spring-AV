package ru.otus.springshell.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.springshell.domain.Result;
import ru.otus.springshell.service.IOService;
import ru.otus.springshell.service.LocalizationMessageService;
import ru.otus.springshell.service.QuestionService;
import ru.otus.springshell.stringifier.QuestionStringifier;
import ru.otus.springshell.service.TestingService;
import ru.otus.springshell.validator.NumberRangeValidator;


@Service
@RequiredArgsConstructor
public class TestingServiceImpl implements TestingService {

    public static final String HEADER_DELIMITER = "***********************************************************";

    private final IOService ioService;

    private final QuestionService questionService;

    private final QuestionStringifier stringifier;

    private final LocalizationMessageService messageService;

    private final NumberRangeValidator validator;

    @Override
    public void displayHeader() {
        ioService.output(HEADER_DELIMITER);
        ioService.output(messageService.getLocalizedMessage("message.greeting.header"));
        ioService.output(HEADER_DELIMITER);
    }

    @Override
    public void processTesting(Result result) {
        var questions = questionService.getAllQuestions();
        questions.forEach(question -> {
            int inputtedAnswer;

            do {
                inputtedAnswer = ioService.readInt(stringifier.stringify(question) +
                        messageService.getLocalizedMessage("message.enter.answer")) - 1;

                if (validator.validate(inputtedAnswer + 1, question.getOptions().size())) {
                    ioService.output(messageService.getLocalizedMessage("error.message.invalid.number.range.input") +
                            question.getOptions().size() + ".");
                }
            } while (validator.validate(inputtedAnswer + 1, question.getOptions().size()));


            var isCorrect = question.getOptions().get(inputtedAnswer).isCorrect();
            result.incrementCorrectAnswers(isCorrect);
            ioService.output(isCorrect ?
                    messageService.getLocalizedMessage("message.right.answer") + "\n" :
                    messageService.getLocalizedMessage("message.wrong.answer") + "\n");
        });
    }
}
