package com.example.taskmanagementapp.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String email;

}
