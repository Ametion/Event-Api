package com.worlds_events_api.worldseventsapi.database.repositories;

import com.worlds_events_api.worldseventsapi.database.entities.Event;
import org.springframework.data.repository.CrudRepository;

public interface IEventsRepo extends CrudRepository<Event, Long> { }