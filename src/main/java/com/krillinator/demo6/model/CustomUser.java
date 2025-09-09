package com.krillinator.demo6.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class CustomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) //orphanRemoval makes sure the task gets removed
    @JsonManagedReference
    private List<Todo> customTask;

    public CustomUser() {}

    public CustomUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Todo> getCustomTask() {
        return customTask;
    }

    public void setCustomTask(List<Todo> customTask) {
        this.customTask = customTask;
    }

}
