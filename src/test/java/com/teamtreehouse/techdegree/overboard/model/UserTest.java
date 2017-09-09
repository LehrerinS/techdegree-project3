package com.teamtreehouse.techdegree.overboard.model;

import com.teamtreehouse.techdegree.overboard.exc.AnswerAcceptanceException;
import com.teamtreehouse.techdegree.overboard.exc.VotingException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class UserTest {
    Board board;
    User userBob;
    User userAlice;
    User userJohn;
    Question question1;
    Question question2;
    Answer answer1;
    Answer answer2;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        board = new Board("JavaTopic");
        userBob = new User(board,"Bob");
        userAlice = new User(board,"Alice");
        userJohn = new User(board,"John");
        question1 = userBob.askQuestion("Where can I learn Collections from?");
        question2 = userAlice.askQuestion("How can I override equals?");
        answer1 = userBob.answerQuestion(question2, "Try with official java doc");
        answer2 = userAlice.answerQuestion(question1, "Try with treehouse");
    }

    @Test
    public void reputationGoesUpWhenQuestionIsUpvoted() throws Exception {
        userBob.upVote(question2);

        assertEquals(5, userAlice.getReputation());
    }

    // exception test for upVote question
    @Test
    public void upvotingYourOwnQuestion() throws Exception {
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot vote for yourself!");
        userBob.upVote(question1);

        assertEquals(5, userBob.getReputation());
    }

//    @Test(expected = VotingException.class)
    @Test
    public void reputationGoesUpWhenAnswerIsUpvoted() throws Exception {
        userAlice.upVote(answer1);

        assertEquals(10, userBob.getReputation());
    }

    // exception test for upVote answer
    @Test
    public void upvotingYourOwnAnswer() throws Exception {
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot vote for yourself!");
        userBob.upVote(answer1);

        assertEquals(10, userBob.getReputation());
    }

    @Test
    public void reputationGoesDownWhenAnswerIsDownvoted() throws Exception {
        userAlice.downVote(answer1);

        assertEquals(-1, userBob.getReputation());
    }

    // exception test for downVote answer
    @Test
    public void downvotingYourOwnAnswer() throws Exception {
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot downvote for yourself!");
        userBob.downVote(answer1);

        assertEquals(-1, userBob.getReputation());
    }

    @Test
    public void reputationGoesUp15WhenAnswerIsAccepted() throws Exception {
        userAlice.acceptAnswer(answer1);

        assertEquals(15, userBob.getReputation());
    }

    // exception test for acceptAnswer
    @Test(expected = AnswerAcceptanceException.class)
//    @Test
    public void acceptingYourOwnAnswer() throws Exception {
        userJohn.acceptAnswer(answer1);

        assertEquals(15, userJohn.getReputation());
    }

}