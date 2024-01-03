package ru.otus.springshell.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.springshell.dao.QuestionDao;
import ru.otus.springshell.domain.Question;
import ru.otus.springshell.service.QuestionService;

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
