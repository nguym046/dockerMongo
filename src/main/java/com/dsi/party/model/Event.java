package com.dsi.party.model;

import org.springframework.data.annotation.Id;

/**
 * Created by nguym046 on 10/31/16.
 */
public class Event {
    @Id
    public String id;

    public String eventName;
    public String attendeesTotal;

    public Event(){};
    public Event(String eventName, String attendeesTotal){
        this.eventName= eventName;
        this.attendeesTotal=attendeesTotal;
    }

    @Override
    public String toString() {
        return String.format(
                "Event[id=%s, eventName='%s']",
                id,eventName);
    }

}