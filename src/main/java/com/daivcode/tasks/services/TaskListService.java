package com.daivcode.tasks.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.daivcode.tasks.domain.entities.TaskList;

public interface TaskListService {

    List<TaskList> listTaskLists();
    
    TaskList createTaskList(TaskList taskList);

    Optional<TaskList> getTaskList(UUID ID);

    TaskList updateTaskList(UUID id, TaskList taskList);
}
