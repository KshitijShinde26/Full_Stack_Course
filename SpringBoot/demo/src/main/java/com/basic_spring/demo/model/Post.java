package com.basic_spring.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Post {

    @Id
    private Integer id;
    private String title;

    // Constructors
    public Post() {}

    public Post(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}