package pro.sky.cw2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.cw2.entity.Question;

import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {


    @InjectMocks
    private JavaQuestionService javaQuestionService;

    @Test
    void add() {
        //Подготовка входных данных
        String answer = "answer";
        String question = "question";

        //Подготовка ожидаемого результата

        Question expectedQuestion = new Question(question, answer);
        //Начало теста
        Question actualQuestion = javaQuestionService.add(question, answer);
        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void remove() {
        //Подготовка входных данных
        String answer = "answer";
        String question = "question";

        //Подготовка ожидаемого результата

        Question expectedQuestion = new Question(question, answer);

        //Начало теста
        javaQuestionService.add(question, answer);
        Question actualQuestion = javaQuestionService.remove(question, answer);
        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void getAll_success() {
        //Подготовка входных данных
        String answer = "answer";
        String question = "question";

        //Подготовка ожидаемого результата
        Question expectedQuestion = new Question(question, answer);
        Collection<Question> expectedQuestions = Collections.singleton(expectedQuestion);

        //Начало теста
        javaQuestionService.add(question, answer);
        Collection<Question> actualQuestion = javaQuestionService.getAll();
        assertEquals(expectedQuestions, actualQuestion);
    }


    @Test
    void getRandomQuestion() {
        //Подготовка входных данных
        String answer = "answer";
        String question = "question";
        String answer2 = "answer2";
        String question2 = "question2";

        //Подготовка ожидаемого результата
        Question expectedQuestion = new Question(question, answer);
        Collection<Question> expectedQuestions = Collections.singleton(expectedQuestion);

        //Начало теста
        javaQuestionService.add(question, answer);
        Collection<Question> actualQuestion = Collections.singleton(javaQuestionService.getRandomQuestion());
        assertEquals(expectedQuestions, actualQuestion);
    }
}