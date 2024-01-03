package ru.otus.springboot.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.springboot.config.ScoreToPassProvider;
import ru.otus.springboot.domain.Result;
import ru.otus.springboot.service.IOService;
import ru.otus.springboot.service.ResultService;
import ru.otus.springboot.stringifier.ResultStringifier;


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
