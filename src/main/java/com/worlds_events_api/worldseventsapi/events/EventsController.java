package com.worlds_events_api.worldseventsapi.events;

import com.worlds_events_api.worldseventsapi.events.requests.AddEventRequest;
import com.worlds_events_api.worldseventsapi.events.requests.GetEventRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EventsController {
    private final EventsService eventsService;

    @Autowired
    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @PostMapping("/addEvent")
    public ResponseEntity AddEvent(@RequestBody AddEventRequest addEventRequest){
        try{
            return ResponseEntity.ok(eventsService.AddEvent(addEventRequest));
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/event")
    public ResponseEntity GetEvent(@RequestBody GetEventRequest getEventRequest){
        try{
            return ResponseEntity.ok(eventsService.GetEvent(getEventRequest));
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
