package com.dsi.party.model;

import java.io.Serializable;

/**
 * Created by nguym046 on 11/4/16.
 */
public class Status implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6573001121291991025L;
    private String state;
    private String message;
    private String published;

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getPublished() {
        return published;
    }
    public void setPublished(String published) {
        this.published = published;
    }
}
