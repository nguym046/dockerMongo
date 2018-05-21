package com.dsi.party.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.dsi.party.model.ServiceStatus;
import com.dsi.party.model.Service;
import com.dsi.party.model.Dependency;
import com.dsi.party.model.Health;
import com.dsi.party.model.Status;
import com.dsi.party.model.Custom;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by nguym046 on 11/4/16.
 */
@RestController
@PropertySource({
        "classpath:build.properties", // TODO: This needs to be build via pom.xml.
        "classpath:mongo.properties"
})
public class ServerStatusController implements IBaseController {

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;
    @Value("${buildNumber.timestamp}")
    private String buildNumberTimestamp;

    //TODO: This is currently stubbed and needs implementation to generate complete server status
    @RequestMapping (value="/server-status", method={RequestMethod.GET,RequestMethod.HEAD}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceStatus> getServerStatus(){
        ServiceStatus ssm = new ServiceStatus();
        ssm.setService(new Service());
        ssm.getService().setStatus(new Status());
        ssm.getService().getStatus().setMessage("Disney Party Microservice");
        ssm.getService().getStatus().setState("HEALTHY");
        ssm.getService().getStatus().setPublished(buildNumberTimestamp);
        ssm.getService().setCustom(new Custom());
        ssm.getService().getCustom().setBuildVersion(buildNumberTimestamp);
        Dependency e = new Dependency();
        e.setName("Mongo DB");
        e.setState("HEALTHY");
        e.setUrl(mongoHost);
        Health health = new Health();
        health.setMem_free(674455552L);
        health.setMem_total(684455552L);
        health.setMem_free_percent(3706343424D);
        health.setOs_uptime(957287L);
        ssm.getService().getCustom().setHealth(health);
        ssm.getService().getCustom().setDependencies(new ArrayList<Dependency>());
        ssm.getService().getCustom().getDependencies().add(e);
        return new ResponseEntity<ServiceStatus>(ssm, HttpStatus.OK);
    }

}
