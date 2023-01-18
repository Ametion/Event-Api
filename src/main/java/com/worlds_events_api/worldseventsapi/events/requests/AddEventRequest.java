package com.worlds_events_api.worldseventsapi.events.requests;

import java.util.Collection;
import java.util.Set;

public class AddEventRequest {
    public String date;
    public String description;
    public String linkToWiki;
    public Long countryId;
    public Set<Long> tagsIds;
}
