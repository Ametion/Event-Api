package com.worlds_events_api.worldseventsapi.countries.responses;

public class CountryResponse {
    public final Long countryId;
    public final String country;

    public CountryResponse(Long countryId, String country) {
        this.countryId = countryId;
        this.country = country;
    }
}
