package com.worlds_events_api.worldseventsapi.database.repositories;

import com.worlds_events_api.worldseventsapi.database.entities.Tag;
import org.springframework.data.repository.CrudRepository;

public interface ITagsRepo extends CrudRepository<Tag, Long> { }