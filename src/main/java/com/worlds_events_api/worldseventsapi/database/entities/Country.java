package com.worlds_events_api.worldseventsapi.database.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String country;

    @OneToMany(mappedBy = "country")
    private Set<Event>  events;

    public Country() { }

    public Country(String country) {
        this.country = country;
    }

    public Country(Long id, String country, Set<Event> events) {
        this.id = id;
        this.country = country;
        this.events = events;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
