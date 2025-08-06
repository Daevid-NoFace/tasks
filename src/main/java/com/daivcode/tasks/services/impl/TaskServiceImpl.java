package com.daivcode.tasks.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.daivcode.tasks.domain.entities.Task;
import com.daivcode.tasks.repositories.TaskRepository;
import com.daivcode.tasks.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> listTasks(UUID taskListId) {
        // TODO Auto-generated method stub
        return taskRepository.findByTaskListId(taskListId);
    }
}
