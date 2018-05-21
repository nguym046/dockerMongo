package com.dsi.party.repository;

import com.dsi.party.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 * Created by nguym046 on 10/31/16.
 */
public interface EventRepository extends MongoRepository<Event, String> {

    public List<Event> findByEventName(String eventName);

}
