package com.example.taskmanager.web.mappers;

import com.example.taskmanager.domain.task.Task;
import com.example.taskmanager.web.dto.task.TaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper extends Mappable<Task, TaskDto> {
}
