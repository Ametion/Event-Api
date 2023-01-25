package com.worlds_events_api.worldseventsapi.events.responses;

import java.util.Collection;

public class EventResponse {
    public final String eventDate;
    public final String eventDescription;
    public final String eventCountry;
    public final String linkToWiki;
    public final Collection<String> eventTags;

    public EventResponse(String eventDate, String eventDescription, String eventCountry, String linkToWiki, Collection<String> eventTags) {
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.eventCountry = eventCountry;
        this.linkToWiki = linkToWiki;
        this.eventTags = eventTags;
    }
}
