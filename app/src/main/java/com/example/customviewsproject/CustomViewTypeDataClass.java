package com.example.customviewsproject;

public class CustomViewTypeDataClass {

    int viewType;
    String inputType;
    String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public int getViewType() {
        return viewType;
    }

    public CustomViewTypeDataClass(int viewType, String inputType, String question) {
        this.viewType = viewType;
        this.inputType = inputType;
        this.question = question;
    }

}
