package com.myapp.model;

public class Option {
    private Integer questionId;
    private Integer optionId;
    private String optionContent;
    private Boolean isCorrect;

    public Option(Integer questionId, Integer optionId, String optionContent, Boolean isCorrect) {
        this.questionId = questionId;
        this.optionId = optionId;
        this.optionContent = optionContent;
        this.isCorrect = isCorrect;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }

    public void setIsCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

}