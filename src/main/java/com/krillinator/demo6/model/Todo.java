package com.krillinator.demo6.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private String title;
    private String tag;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // join handles foreign Keys (owning side)
    @JsonBackReference
    private CustomUser user;
    // nullable = false, it must have an associated User
    // name = "user_id" creates a column (join = "Ansluter sig till")
    // Technically this is the owner of the RELATIONSHIP

    public Todo() {}

    // Getters & Setters
    public CustomUser getUser() {
        return user;
    }

    public void setUser(CustomUser user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
