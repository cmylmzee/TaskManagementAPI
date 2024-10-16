package com.example.taskmanagementapp.mapper;

import com.example.taskmanagementapp.dto.TaskDto;
import com.example.taskmanagementapp.entity.Task;

public class TaskMapper {
    public static Task mapToTask(TaskDto taskDto) {
        Task task = new Task(
                taskDto.getId(),
                taskDto.getTaskName(),
                taskDto.getDescription()
        );

        return task;
    }


    public static TaskDto mapToTaskDto(Task task) {
        TaskDto taskDto = new TaskDto(
                task.getId(),
                task.getTaskName(),
                task.getDescription()
        );

        return taskDto;
    }
}
