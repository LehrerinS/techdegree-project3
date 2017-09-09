package com.teamtreehouse.techdegree.overboard.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BoardTest {
    private User user;
    private Question question1;
    private Question question2;
    private Board board;
    private Answer answer1;
    private Answer answer2;

    @Before
    public void setUp() throws Exception {
        board = new Board("testTopic");
        user = new User(board, "testUser");
        question1 = new Question(user, "This is my first question");
        question2 = new Question(user, "This is my second question");
        answer1 = new Answer(question1, user, "This is my first answer");
        answer2 = new Answer(question1, user, "This is my second answer");
    }

    @Test
    public void createUserTest() throws Exception {
        User x = board.createUser("My new user name");

        assertEquals(x, board.getUsers().get(0));
    }

    @Test
    public void addQuestionTest() throws Exception {
        List<Question> questions = new ArrayList<Question>();
        questions.add(question1);
        questions.add(question2);

        board.addQuestion(question1);
        board.addQuestion(question2);

        assertEquals(questions, board.getQuestions());
    }

    @Test
    public void addAnswerTest() throws Exception {
        List<Answer> answers = new ArrayList<Answer>();
        answers.add(answer1);
        answers.add(answer2);

        board.addAnswer(answer1);
        board.addAnswer(answer2);

        assertEquals(answers, board.getAnswers());

    }

}