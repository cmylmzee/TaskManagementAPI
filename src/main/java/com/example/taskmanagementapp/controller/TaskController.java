package com.example.taskmanagementapp.controller;

import com.example.taskmanagementapp.dto.TaskDto;
import com.example.taskmanagementapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        return new ResponseEntity<>(taskService.createTask(taskDto), HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<TaskDto> updateTaskById(@RequestBody TaskDto taskDto, @PathVariable  Long id) {
        return new ResponseEntity<>(taskService.updateTaskById(taskDto, id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
    }

    @GetMapping("/allTasks")
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @PostMapping("/assign")
    public ResponseEntity<String> assignTaskToUser(@RequestParam(name ="userId") Long userId, @RequestParam(name = "taskId") Long taskId) {
        taskService.assingTaskToUser(userId, taskId);
        return ResponseEntity.ok("The task is assigned successfully");
    }



}
