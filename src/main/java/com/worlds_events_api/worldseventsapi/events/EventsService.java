package com.worlds_events_api.worldseventsapi.events;

import com.worlds_events_api.worldseventsapi.database.entities.Event;
import com.worlds_events_api.worldseventsapi.database.repositories.ICountriesRepo;
import com.worlds_events_api.worldseventsapi.database.repositories.IEventsRepo;
import com.worlds_events_api.worldseventsapi.database.repositories.ITagsRepo;
import com.worlds_events_api.worldseventsapi.events.requests.AddEventRequest;
import com.worlds_events_api.worldseventsapi.events.requests.GetEventRequest;
import com.worlds_events_api.worldseventsapi.events.responses.EventResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Service
public class EventsService {
    private final IEventsRepo eventsRepo;
    private final ICountriesRepo countriesRepo;
    private final ITagsRepo tagsRepo;

    @Autowired
    public EventsService(IEventsRepo eventsRepo, ICountriesRepo countriesRepo, ITagsRepo tagsRepo) {
        this.eventsRepo = eventsRepo;
        this.countriesRepo = countriesRepo;
        this.tagsRepo = tagsRepo;
    }

    public boolean AddEvent(AddEventRequest addEventRequest) throws Exception {
        try{
            var country = countriesRepo.findById(addEventRequest.countryId).get();
            var tags = tagsRepo.findByIdIn(addEventRequest.tagsIds);
            var event = new Event(addEventRequest.description, addEventRequest.date, addEventRequest.linkToWiki, country, tags);

            eventsRepo.save(event);

            return true;
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    public EventResponse GetEvent(GetEventRequest getEventRequest) throws Exception {
        try{
            var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            var dateBefore = LocalDate.parse(getEventRequest.dateBefore, formatter);
            var dateAfter = LocalDate.parse(getEventRequest.dateAfter, formatter);

            var country = countriesRepo.findById(getEventRequest.countryId).get();
            var tags = tagsRepo.findByIdIn(getEventRequest.tags);

            var events = (ArrayList<Event>)eventsRepo.findAll();

            var chosenEvents = new ArrayList<Event>();

            events.forEach(e -> {
                var eventDate = LocalDate.parse(e.getDate(), formatter);

                if(tags.isEmpty()){
                    if((eventDate.isBefore(dateAfter) && eventDate.isAfter(dateBefore) || (eventDate.isEqual(dateAfter) || eventDate.isEqual(dateBefore)))){
                        chosenEvents.add(e);
                    }
                }

                if(CollectionUtils.containsAny(e.getTags(), tags) && e.getCountry().equals(country)){
                    if((eventDate.isBefore(dateAfter) && eventDate.isAfter(dateBefore) || (eventDate.isEqual(dateAfter) || eventDate.isEqual(dateBefore)))){
                        chosenEvents.add(e);
                    }
                }
            });

            var event = chosenEvents.get((int)Math.floor(Math.random() * (chosenEvents.size())));

            var eventTags = new ArrayList<String>();

            event.getTags().forEach(t -> eventTags.add(t.getTag()));

            return new EventResponse(event.getDate(), event.getDescription(), event.getCountry().getCountry(), eventTags);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
