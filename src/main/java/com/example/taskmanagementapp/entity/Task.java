package com.example.taskmanagementapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskName;
    private String description;
    private String taskStatus;
    private String taskType;
    private LocalDateTime taskCreationDate = LocalDateTime.now();

    @ManyToMany(mappedBy = "tasks")
    private Set<User> assignedUsers;



    public Task(Long id, String taskName, String description) {
    }
}
