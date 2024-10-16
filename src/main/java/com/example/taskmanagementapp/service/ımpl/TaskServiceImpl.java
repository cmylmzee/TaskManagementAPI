package com.example.taskmanagementapp.service.ımpl;

import com.example.taskmanagementapp.dto.TaskDto;
import com.example.taskmanagementapp.entity.Task;
import com.example.taskmanagementapp.mapper.TaskMapper;
import com.example.taskmanagementapp.repository.TaskRepository;
import com.example.taskmanagementapp.repository.UserRepository;
import com.example.taskmanagementapp.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {


    TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task task = new Task();

        task.setTaskName(taskDto.getTaskName());
        task.setDescription(taskDto.getDescription());
        taskDto.setId(task.getId());
        taskRepository.save(task);

        return taskDto;
    }

    @Override
    public TaskDto updateTaskById(TaskDto taskDto, Long id) {
        Task task = taskRepository.getById(id);
        task.setTaskName(taskDto.getTaskName());
        task.setDescription(taskDto.getDescription());
        TaskDto updatedTask = TaskMapper.mapToTaskDto(task);

        return updatedTask;
    }

    @Override
    public TaskDto getTaskById(Long id) {
       Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException());

       return TaskMapper.mapToTaskDto(task);


    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();



       return tasks.stream().map((task -> TaskMapper.mapToTaskDto(task))).collect(Collectors.toList());
    }
}
