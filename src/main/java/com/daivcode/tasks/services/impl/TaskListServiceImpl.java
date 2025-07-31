package com.daivcode.tasks.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import com.daivcode.tasks.repositories.TaskListRepository;

import com.daivcode.tasks.domain.entities.TaskList;
import com.daivcode.tasks.services.TaskListService;

@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskList> listTaskLists() {
        
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {

        if (taskList.getId() != null) {
            throw new IllegalArgumentException("Task list already has an ID!");
        }

        if (taskList.getTittle() == null || taskList.getTittle().isBlank()) {
            throw new IllegalArgumentException("Task list tittle must be present!");
        }

        LocalDateTime now = LocalDateTime.now();

        return taskListRepository.save(new TaskList(
            null,
            taskList.getTittle(),
            taskList.getDescription(),
            null,
            now,
            now
        ));
    }

}
