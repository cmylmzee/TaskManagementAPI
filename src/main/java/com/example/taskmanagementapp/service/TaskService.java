package com.example.taskmanagementapp.service;

import com.example.taskmanagementapp.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface TaskService {

     TaskDto createTask(TaskDto taskDto);
     TaskDto updateTaskById(TaskDto taskDto, Long id);
     TaskDto getTaskById(Long id);
     List<TaskDto> getAllTasks();
     public void assingTaskToUser(Long userId, Long taskId);
}
