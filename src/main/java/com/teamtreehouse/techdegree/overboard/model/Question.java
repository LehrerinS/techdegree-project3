package com.teamtreehouse.techdegree.overboard.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Question extends Post {
    private User author;
    private List<Answer> answers;
    private String text;
    private Set<User> upVoters;
    private Set<User> downVoters;

    public Question(User author, String text) {
        super(author, text);
        answers = new ArrayList<>();
    }

    protected void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public List<Answer> getAnswers() {
        return Collections.unmodifiableList(answers);
    }

//    @Override
//    public boolean equals(Object that){
//        if(this == that) return true;//if both of them points the same address in memory
//
//        if(!(that instanceof Question)) return false; // if "that" is not a Question or a childclass
//
//        Question thatQuestion = (Question)that; // than we can cast it to Question safely
//
//        return this.author.equals(thatQuestion.author) && this.text.equals(thatQuestion.text);// if they have the same author and same text, then the 2 objects are equal unless they're pointing to different memory adresses
//    }
//
//    @Override
//    public int hashCode() {
//        int result = author.hashCode();
//        result = 31 * result + text.hashCode();
//        return result;
//    }


}
