package com.example.taskmanager.web.mappers;

import com.example.taskmanager.domain.user.User;
import com.example.taskmanager.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto> {
}
