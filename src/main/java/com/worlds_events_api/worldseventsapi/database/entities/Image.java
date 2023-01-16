package com.worlds_events_api.worldseventsapi.database.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String image;

    @ManyToMany(mappedBy = "images")
    private Set<Event> events;

    public Image() { }

    public Image(String image, Set<Event> events) {
        this.image = image;
        this.events = events;
    }

    public Image(Long id, String image, Set<Event> events) {
        this.id = id;
        this.image = image;
        this.events = events;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
