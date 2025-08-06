package com.daivcode.tasks.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daivcode.tasks.domain.dto.TaskDto;
import com.daivcode.tasks.mappers.TaskMapper;
import com.daivcode.tasks.services.TaskService;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(path = "/task-lists/{task_list_id}/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping
    public List<TaskDto> listTasks(@PathVariable("task_list_id") UUID taskListId) {
        return taskService.listTasks(taskListId)
                .stream()
                .map(taskMapper::toDto)
                .toList();
    }
    
}
