package com.teamtreehouse.techdegree.overboard.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionTest {

    private User user;
    private Question question;
    private Board board;
    private Answer answer;

    @Before
    public void setUp() throws Exception {
        board = new Board("testTopic");
        user = new User(board, "testUser");
        question = new Question(user, "This is my question");
        answer = new Answer(question, user, "This is my answer");
    }

    @Test
    public void addAnswerTest() throws Exception {
        question.addAnswer(answer);

        assertEquals(answer, question.getAnswers().get(0));
    }

}