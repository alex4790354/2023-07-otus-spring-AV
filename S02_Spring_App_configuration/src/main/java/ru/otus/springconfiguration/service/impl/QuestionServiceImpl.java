package ru.otus.springconfiguration.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.springconfiguration.dao.QuestionDao;
import ru.otus.springconfiguration.domain.Question;
import ru.otus.springconfiguration.service.QuestionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    @Override
    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }
}
