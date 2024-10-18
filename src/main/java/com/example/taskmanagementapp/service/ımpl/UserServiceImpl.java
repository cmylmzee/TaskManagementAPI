package com.example.taskmanagementapp.service.ımpl;

import com.example.taskmanagementapp.dto.UserDto;
import com.example.taskmanagementapp.entity.User;
import com.example.taskmanagementapp.entity.Task;

import com.example.taskmanagementapp.mapper.TaskMapper;
import com.example.taskmanagementapp.mapper.UserMapper;
import com.example.taskmanagementapp.repository.TaskRepository;
import com.example.taskmanagementapp.repository.UserRepository;
import com.example.taskmanagementapp.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("UserService")
public class UserServiceImpl implements UserService {

    private final TaskRepository taskRepository;
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }


    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);

        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.getById(id);
        return UserMapper.mapToUserDto(user);

    }

    @Override
    public List<UserDto> getAllUsers() {
          List<User> users =  userRepository.findAll();

        return users.stream().map((user -> UserMapper.mapToUserDto(user))).collect(Collectors.toList());

    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


}
