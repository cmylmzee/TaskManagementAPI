package com.example.taskmanagementapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String role;

    @ManyToMany
    @JoinTable(
            name = "User_Task",  // Ara tablonun adı
            joinColumns = @JoinColumn(name = "user_id"),  // Ara tablodaki user_id sütunu
            inverseJoinColumns = @JoinColumn(name = "task_id")  // Ara tablodaki task_id sütunu
    )
    private Set<Task> tasks;

    public User(Long id, String name, String surname, String email) {
    }
}
