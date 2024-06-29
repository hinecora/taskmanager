package com.example.taskmanager.web.mappers;

import com.example.taskmanager.domain.user.User;
import com.example.taskmanager.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto dto);

}
