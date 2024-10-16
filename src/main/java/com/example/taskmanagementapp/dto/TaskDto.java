package com.example.taskmanagementapp.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class TaskDto {

    private Long id;

    private String taskName;
    private String description;

}
