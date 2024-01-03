package ru.otus.springshell.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.springshell.domain.Result;
import ru.otus.springshell.service.ResultService;
import ru.otus.springshell.service.TestingService;
import ru.otus.springshell.service.UserService;



@Component
@RequiredArgsConstructor
public class AppController implements Controller {

    private final TestingService testingService;

    private final UserService userService;

    private final ResultService resultService;

    @Override
    public void executeTesting() {
        testingService.displayHeader();

        var result = new Result(userService.getUser());

        testingService.processTesting(result);

        resultService.displayResult(result);
    }
}

