package com.worlds_events_api.worldseventsapi.database.repositories;

import com.worlds_events_api.worldseventsapi.database.entities.Image;
import org.springframework.data.repository.CrudRepository;

public interface IImagesRepo extends CrudRepository<Image, Long> { }