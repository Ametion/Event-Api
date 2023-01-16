package com.worlds_events_api.worldseventsapi.tags.responses;

public class TagResponse {
    public final Long tagId;
    public final String tag;

    public TagResponse(Long tagId, String tag) {
        this.tagId = tagId;
        this.tag = tag;
    }
}
