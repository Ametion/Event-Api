package com.worlds_events_api.worldseventsapi.events.responses;

import java.util.Collection;
import java.util.Set;

public class EventResponse {
    public final String eventDate;
    public final String eventDescription;
    public final String eventCountry;

    public final Collection<String> eventTags;

    public EventResponse(String eventDate, String eventDescription, String eventCountry, Collection<String> eventTags) {
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.eventCountry = eventCountry;
        this.eventTags = eventTags;
    }
}
