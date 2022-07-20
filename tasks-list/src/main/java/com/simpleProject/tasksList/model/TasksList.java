package com.simpleProject.tasksList.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TASKS_LIST")
public class TasksList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TASKS_ID", nullable = false)
    private Long id;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @ManyToOne
    private User user;

    public TasksList() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TasksList)) return false;
        TasksList tasksList = (TasksList) o;
        return Objects.equals(getId(), tasksList.getId()) && Objects.equals(getDescription(), tasksList.getDescription()) && Objects.equals(getUser(), tasksList.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getUser());
    }

    @Override
    public String toString() {
        return "TasksList{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
