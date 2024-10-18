package com.example.taskmanagementapp.mapper;

import com.example.taskmanagementapp.dto.TaskDto;
import com.example.taskmanagementapp.entity.Task;

public class TaskMapper {
    public static Task mapToTask(TaskDto taskDto) {
        Task task = new Task(
        );

        task.setId(taskDto.getId());
        task.setDescription(taskDto.getDescription());
        task.setTaskName(taskDto.getTaskName());

        return task;
    }


    public static TaskDto mapToTaskDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTaskName(task.getTaskName());
        taskDto.setDescription(task.getDescription());


        return taskDto;
    }
}
