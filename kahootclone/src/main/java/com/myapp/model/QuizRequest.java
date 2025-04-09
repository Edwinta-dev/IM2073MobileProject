package com.myapp.model;

import javax.xml.crypto.Data;

public class QuizRequest {
    private String action;
    private Data data; // Assuming 'data' is an object, if it's a primitive type you can change it
                       // accordingly

    // Getters and setters
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
