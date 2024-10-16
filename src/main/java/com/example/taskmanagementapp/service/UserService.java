package com.example.taskmanagementapp.service;

import com.example.taskmanagementapp.dto.UserDto;
import com.example.taskmanagementapp.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public UserDto createUser(UserDto userDto);
    public UserDto updateUser(UserDto userDto);
    public UserDto getUserById(Long id);
    public List<UserDto> getAllUsers();
    public void deleteUserById(Long id);
}
