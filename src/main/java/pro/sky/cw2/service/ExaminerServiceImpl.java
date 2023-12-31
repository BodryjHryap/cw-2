package pro.sky.cw2.service;

import org.springframework.stereotype.Service;
import pro.sky.cw2.entity.Question;
import pro.sky.cw2.exception.ExaminerServiceException;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int size) {

        if (questionService.getAll().size() < size) {
            throw new ExaminerServiceException("Запрошено большее количество вопросов, чем находится в сервисе");
        }

        Collection<Question> result = new HashSet<>();
        while (result.size() <= size) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}
