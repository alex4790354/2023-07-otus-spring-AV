package ru.otus.springboot.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.springboot.domain.Result;
import ru.otus.springboot.service.IOService;
import ru.otus.springboot.service.LocalizationMessageService;
import ru.otus.springboot.service.QuestionService;
import ru.otus.springboot.stringifier.QuestionStringifier;
import ru.otus.springboot.service.TestingService;
import ru.otus.springboot.validator.NumberRangeValidator;


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
