package com.udacity.gradle.builditbigger.gcmjokeserver;

/** The object model for the data we are sending through endpoints */
public class JokerBean {

    private String joke;

    public String getData() {
        return joke;
    }

    public void setData(String joke) {
        this.joke = joke;
    }
}