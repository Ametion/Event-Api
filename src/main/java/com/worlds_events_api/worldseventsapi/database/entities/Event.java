package com.worlds_events_api.worldseventsapi.database.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false, name = "linkToWiki")
    private String linkToWiki;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Country country;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "eventImages",
            joinColumns = @JoinColumn(name = "eventId"),
            inverseJoinColumns = @JoinColumn(name = "imageId"))
    private Set<Image> images;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "eventTags",
            joinColumns = @JoinColumn(name = "eventId"),
            inverseJoinColumns = @JoinColumn(name = "tagId"))
    private Set<Tag> tags;

    public Event() {
    }

    public Event(String description, Date date, String linkToWiki, Country country, Set<Image> images, Set<Tag> tags) {
        this.description = description;
        this.date = date;
        this.linkToWiki = linkToWiki;
        this.country = country;
        this.images = images;
        this.tags = tags;
    }

    public Event(Long id, String description, Date date, String linkToWiki, Country country, Set<Image> images, Set<Tag> tags) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.linkToWiki = linkToWiki;
        this.country = country;
        this.images = images;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLinkToWiki() {
        return linkToWiki;
    }

    public void setLinkToWiki(String linkToWiki) {
        this.linkToWiki = linkToWiki;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}