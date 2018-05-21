package com.dsi.party.model;

/**
 * Created by nguym046 on 11/4/16.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Custom implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 2047234394894187466L;

    private String buildVersion = null;
    private Health health = null;
    private List<Dependency> dependencies = null;

    public Health getHealth() {return health;}
    public void setHealth(Health health) {
        this.health = health;
    }
    public String getBuildVersion() {
        return buildVersion;
    }
    public void setBuildVersion(String buildVersion) {
        this.buildVersion = buildVersion;
    }
    public List<Dependency> getDependencies() {return dependencies;}
    public void setDependencies(List<Dependency> dependencies) {
        this.dependencies = dependencies;
    }

}
