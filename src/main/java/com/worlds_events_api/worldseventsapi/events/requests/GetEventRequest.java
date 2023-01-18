package com.worlds_events_api.worldseventsapi.events.requests;

import java.util.Set;

public class GetEventRequest {
    public Long countryId;
    public String dateBefore;
    public String dateAfter;
    public Set<Long> tags;
}
