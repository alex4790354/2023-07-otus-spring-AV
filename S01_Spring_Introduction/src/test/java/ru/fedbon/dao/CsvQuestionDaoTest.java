package ru.fedbon.dao;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import ru.otus.spring.domain.Question;
import ru.otus.spring.dao.CsvQuestionDao;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class CsvQuestionDaoTest {

    private CsvQuestionDao csvQuestionDao;

    @Mock
    private ClassLoader classLoader;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        csvQuestionDao = new CsvQuestionDao("questions.csv");
    }

    @Test
    void testGetAll() {
        // given
        var inputStream = getClass().getResourceAsStream("/questions.csv");
        when(classLoader.getResourceAsStream("questions.csv")).thenReturn(inputStream);
        csvQuestionDao = new CsvQuestionDao("questions.csv");

        // when
        List<Question> questions = csvQuestionDao.getAll();

        // then
        assertNotNull(questions);
        assertFalse(questions.isEmpty());

        for (Question question : questions) {
            assertNotNull(question.getText());
            assertNotNull(question.getOptions());
            assertFalse(question.getOptions().isEmpty());
        }
    }
}
