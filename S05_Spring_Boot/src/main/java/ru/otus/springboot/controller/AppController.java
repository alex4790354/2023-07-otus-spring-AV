package ru.otus.springboot.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.springboot.domain.Result;
import ru.otus.springboot.service.ResultService;
import ru.otus.springboot.service.TestingService;
import ru.otus.springboot.service.UserService;



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

