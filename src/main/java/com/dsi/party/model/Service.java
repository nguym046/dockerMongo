package com.dsi.party.model;

/**
 * Created by nguym046 on 11/4/16.
 */
import java.io.Serializable;

public class Service implements Serializable {
    /**
    /**
     *
     */
    private static final long serialVersionUID = -5417340460726012435L;

    private Status status = null;
    private Custom custom = null;

    public Status getStatus() {return status;}

    public void setStatus(Status status) {
        this.status = status;
    }

    public Custom getCustom() {return custom;}

    public void setCustom(Custom custom) {
        this.custom = custom;
    }
}

