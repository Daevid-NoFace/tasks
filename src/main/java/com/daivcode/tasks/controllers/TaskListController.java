package com.daivcode.tasks.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daivcode.tasks.domain.dto.TaskListDTO;
import com.daivcode.tasks.mappers.TaskListMapper;
import com.daivcode.tasks.services.TaskListService;

@Controller
@RequestMapping(path = "/task-lists")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping
    public List<TaskListDTO> listTaskLists() {
        
        return taskListService.listTaskLists().stream()
            .map(taskListMapper::toDto)
            .toList();

    }
}
