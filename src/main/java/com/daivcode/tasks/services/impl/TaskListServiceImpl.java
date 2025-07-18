package com.daivcode.tasks.services.impl;

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

}
