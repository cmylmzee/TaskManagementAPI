package com.example.taskmanagementapp.mapper;

import com.example.taskmanagementapp.dto.UserDto;
import com.example.taskmanagementapp.entity.User;

public class UserMapper {

    public static User mapToUser(UserDto userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getEmail()
        );
        return user;
    }

    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail()
        );

        return userDto;
    }



}
