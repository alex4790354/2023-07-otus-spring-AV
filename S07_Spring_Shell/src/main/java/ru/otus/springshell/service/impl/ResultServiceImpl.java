package ru.otus.springshell.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.springshell.config.ScoreToPassProvider;
import ru.otus.springshell.domain.Result;
import ru.otus.springshell.service.IOService;
import ru.otus.springshell.service.ResultService;
import ru.otus.springshell.stringifier.ResultStringifier;


@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {

    private final IOService ioService;

    private final ResultStringifier stringifier;

    private final ScoreToPassProvider propertiesProvider;

    @Override
    public void displayResult(Result result) {
        ioService.output(stringifier.stringify(result, propertiesProvider.getScoreToPass()));
    }
}
