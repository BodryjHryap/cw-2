package pro.sky.cw2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.cw2.exception.ExaminerServiceException;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions_withExaminerServiceException() {
        //Подготовка входных данных
        String answer = "answer";
        String question = "question";
        String answer2 = "answer2";
        String question2 = "question2";
        String answer3 = "answer3";
        String question3 = "question3";

        //Подготовка ожидаемого результата
        when(javaQuestionService.getAll()).thenReturn(Collections.emptyList());
        String expectedMessage = "Запрошено большее количество вопросов, чем находится в сервисе";

        //Начало теста
        javaQuestionService.add(question, answer);
        javaQuestionService.add(question2, answer2);
        javaQuestionService.add(question3, answer3);
        Exception exception = assertThrows(
                ExaminerServiceException.class,
                () -> examinerService.getQuestions(2));
        assertEquals(expectedMessage, exception.getMessage());
    }
}