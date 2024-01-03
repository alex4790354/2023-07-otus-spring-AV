package ru.otus.springshell.command;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.springshell.controller.AppController;
import ru.otus.springshell.domain.Result;
import ru.otus.springshell.service.ResultService;
import ru.otus.springshell.service.TestingService;
import ru.otus.springshell.service.UserService;


@ShellComponent
@RequiredArgsConstructor
public class ShellCommand {

    private final AppController appController;

    private final TestingService testingService;

    private final ResultService resultService;

    private final UserService userService;

    @ShellMethod(value = "startTesting", key = {"s", "start-testing"})
    public void startTesting() {
        appController.executeTesting();
    }

    @ShellMethod(value = "executeDisplayHeader", key = {"d", "display-header"})
    public void executeDisplayHeader() {
        testingService.displayHeader();
    }

    @ShellMethod(value = "executeProcessTesting", key = {"p", "process-testing"})
    public void executeProcessTesting() {
        testingService.processTesting(new Result(userService.getUser()));
    }

    @ShellMethod(value = "executeDisplayResult", key = {"r", "display-result"})
    public void executeDisplayResult() {
        resultService.displayResult((new Result(userService.getUser())));
    }

}
