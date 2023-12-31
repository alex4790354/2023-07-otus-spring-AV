package ru.otus.springshell.stringifier;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.springshell.domain.Result;
import ru.otus.springshell.service.LocalizationMessageService;


@Component
@RequiredArgsConstructor
public class ResultStringifierImpl implements ResultStringifier {

    private final LocalizationMessageService messageService;

    @Override
    public String stringify(Result result, int scoreToPass) {
        var userFirstName = result.getUser().getFirstName();
        var userLastName = result.getUser().getLastName();
        var correctAnswers = result.getCorrectAnswers();
        var total = result.getTotal();
        return String.format(messageService.getLocalizedMessage("test.result.pattern"), userFirstName,
                userLastName, total, correctAnswers, scoreToPass, determineResult(correctAnswers, scoreToPass));
    }

    private String determineResult(int correctAnswers, int scoreToPass) {
        return correctAnswers >= scoreToPass ?
                messageService.getLocalizedMessage("message.test.passed") :
                messageService.getLocalizedMessage("message.test.failed");
    }
}

