package com.dsi.party.model;

/**
 * Created by nguym046 on 11/4/16.
 */
import java.io.Serializable;

public class ServiceStatus implements Serializable {
    /*
    /**
     *
     */
    private static final long serialVersionUID = -7473320601852336019L;

    private Service service = null;

    public Service getService() {return service;}

    public void setService(Service service) {
        this.service = service;
    }

}
