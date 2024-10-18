package com.example.taskmanagementapp.service.ımpl;

import com.example.taskmanagementapp.dto.TaskDto;
import com.example.taskmanagementapp.entity.Task;
import com.example.taskmanagementapp.entity.User;

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
    UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }


    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task task = TaskMapper.mapToTask(taskDto);
        Task savedTask = taskRepository.save(task);


        return TaskMapper.mapToTaskDto(savedTask);
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

    @Override
    public void assingTaskToUser(Long userId, Long taskId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User is not find" + userId));
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task is not find" + taskId));

        user.getTasks().add(task);

        userRepository.save(user);
    }
}
