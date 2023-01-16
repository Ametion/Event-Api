package com.worlds_events_api.worldseventsapi.database.repositories;

import com.worlds_events_api.worldseventsapi.database.entities.Country;
import org.springframework.data.repository.CrudRepository;

public interface ICountriesRepo extends CrudRepository<Country, Long> { }