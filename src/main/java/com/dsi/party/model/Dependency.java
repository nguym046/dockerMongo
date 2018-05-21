package com.dsi.party.model;

/**
 * Created by nguym046 on 11/4/16.
 */
import java.io.Serializable;

public class Dependency implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6705289202296301411L;

    private String name;
    private String url;
    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
