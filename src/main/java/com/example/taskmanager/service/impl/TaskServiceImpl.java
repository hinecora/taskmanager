package com.example.taskmanager.service.impl;

import com.example.taskmanager.domain.exception.ResourceNotFoundException;
import com.example.taskmanager.domain.task.Status;
import com.example.taskmanager.domain.task.Task;
import com.example.taskmanager.domain.user.User;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.service.TaskService;
import com.example.taskmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;


    @Override
    @Transactional(readOnly = true)
    public Task getById(
            Long id
    ) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found."));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getAllByUserId(Long id) {
        return taskRepository.findAllByUserId(id);
    }

    @Override
    @Transactional
    public Task update(Task task) {
        if (task.getStatus() == null) {
            task.setStatus(Status.TODO);
        }
        taskRepository.save(task);
        return task;
    }

    @Override
    @Transactional
    public Task create(Task task, Long userId) {
        User user = userService.getById(userId);
        task.setStatus(Status.TODO);
        user.getTasks().add(task);
        userService.update(user);
        return task;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

}
