package pro.sky.cw2.service;

import org.springframework.stereotype.Service;
import pro.sky.cw2.entity.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {

    private final Collection<Question> questions = new HashSet<>();
    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionForRemove = new Question(question, answer);
        questions.remove(questionForRemove);
        return questionForRemove;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        int randomIdx = new Random().nextInt(questions.size());
        return new ArrayList<>(questions).get(randomIdx);
    }
}
