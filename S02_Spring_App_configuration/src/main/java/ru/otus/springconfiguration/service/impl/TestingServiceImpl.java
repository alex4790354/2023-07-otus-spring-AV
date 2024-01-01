package ru.otus.springconfiguration.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.springconfiguration.domain.Result;
import ru.otus.springconfiguration.service.IOService;
import ru.otus.springconfiguration.service.QuestionService;
import ru.otus.springconfiguration.service.TestingService;
import ru.otus.springconfiguration.utils.Message;

@Service
public class TestingServiceImpl implements TestingService {

    private final IOService ioService;

    private final QuestionService questionService;

    private final QuestionStringifier questionStringifier;


    public TestingServiceImpl(IOService ioService, QuestionService questionService,
                              QuestionStringifier questionStringifier) {
        this.ioService = ioService;
        this.questionService = questionService;
        this.questionStringifier = questionStringifier;
    }

    @Override
    public void displayHeader() {
        ioService.output(Message.MSG_HEADER);
        ioService.output(Message.HEADER_DELIMITER);
    }

    @Override
    public void processTesting(Result result) {
        var questions = questionService.getAllQuestions();
        questions.forEach(question -> {
            var option = ioService.readInt(questionStringifier.stringify(question) +
                    Message.MSG_ENTER_ANSWER, question.getOptions().size()) - 1;
            var isCorrect = question.getOptions().get(option).isCorrect();
            result.incrementCorrectAnswers(isCorrect);
            ioService.output(isCorrect ? Message.MSG_RIGHT_ANSWER : Message.MSG_WRONG_ANSWER);
        });
    }
}
