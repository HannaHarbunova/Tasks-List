package com.simpleProject.tasksList.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TasksList> tasksLists;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TasksList> getTasksLists() {
        return tasksLists;
    }

    public void setTasksLists(List<TasksList> tasksLists) {
        this.tasksLists = tasksLists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getUserName(),
                user.getUserName()) && Objects.equals(getPassword(),
                user.getPassword()) && Objects.equals(getTasksLists(), user.getTasksLists());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getPassword(), getTasksLists());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", tasksLists=" + tasksLists +
                '}';
    }
}
