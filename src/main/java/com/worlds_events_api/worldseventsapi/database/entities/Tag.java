package com.worlds_events_api.worldseventsapi.database.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tag;

    @ManyToMany(mappedBy = "tags")
    private Set<Event> events;

    public Tag() { }

    public Tag(String tag) {
        this.tag = tag;
    }

    public Tag(Long id, String tag, Set<Event> events) {
        this.id = id;
        this.tag = tag;
        this.events = events;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
