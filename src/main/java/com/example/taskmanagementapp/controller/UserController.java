package com.example.taskmanagementapp.controller;

import com.example.taskmanagementapp.dto.UserDto;
import com.example.taskmanagementapp.entity.User;
import com.example.taskmanagementapp.mapper.UserMapper;
import com.example.taskmanagementapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody  UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

}
