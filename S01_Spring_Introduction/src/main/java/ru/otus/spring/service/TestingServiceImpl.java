package ru.otus.spring.service;


import lombok.AllArgsConstructor;
import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.domain.Question;
import ru.otus.spring.service.api.TestingService;
import ru.otus.spring.utils.Stringifier;

@AllArgsConstructor
public class TestingServiceImpl implements TestingService {

    private final QuestionDao csvQuestionDao;
    private final Stringifier<Question> stringifier;

    @Override
    public void executeTesting() {
        var questions = csvQuestionDao.getAll();
        var strings = stringifier.stringify(questions);
        strings.forEach(System.out::println);
    }
}

