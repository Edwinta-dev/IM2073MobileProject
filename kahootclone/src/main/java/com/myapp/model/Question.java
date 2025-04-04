package com.myapp.model;

import java.util.List;

public class Question {
    private Integer quizId;
    private Integer questionId;
    private String questionContent;
    private List<Option> options;

    public Question(Integer quizId, Integer questionId, String questionContent, List<Option> options) {
        this.quizId = quizId;
        this.questionId = questionId;
        this.questionContent = questionContent;
        this.options = options;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public List<Option> getOptions() {
        return options;
    }

}