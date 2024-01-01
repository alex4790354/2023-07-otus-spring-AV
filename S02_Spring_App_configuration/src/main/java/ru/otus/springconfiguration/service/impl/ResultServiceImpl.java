package ru.otus.springconfiguration.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.springconfiguration.domain.Result;
import ru.otus.springconfiguration.service.IOService;
import ru.otus.springconfiguration.service.ResultService;

@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {

    private final IOService ioService;

    private final ResultStringifier resultStringifier;

    @Override
    public void displayResult(Result result) {
        ioService.output(resultStringifier.stringify(result, resultStringifier.getScoreToPass()));
    }
}
