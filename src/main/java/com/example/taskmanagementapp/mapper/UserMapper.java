package com.example.taskmanagementapp.mapper;

import com.example.taskmanagementapp.dto.UserDto;
import com.example.taskmanagementapp.entity.User;

public class UserMapper {

    public static User mapToUser(UserDto userDto) {
        User user = new User(

        );
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setSurname(userDto.getSurname());
        user.setId(userDto.getId());
        return user;
    }

    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto(
        );
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setEmail(user.getEmail());


        return userDto;
    }



}
