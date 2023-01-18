package com.worlds_events_api.worldseventsapi.database.repositories;

import com.worlds_events_api.worldseventsapi.database.entities.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Set;

public interface ITagsRepo extends CrudRepository<Tag, Long> {
    Set<Tag> findByIdIn(Collection<Long> id);
}