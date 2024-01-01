package ru.otus.springconfiguration.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.springconfiguration.domain.Result;
import ru.otus.springconfiguration.service.ResultService;
import ru.otus.springconfiguration.service.TestingService;
import ru.otus.springconfiguration.service.UserService;


@Component
@RequiredArgsConstructor
public class TestingAppController implements Controller {

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

