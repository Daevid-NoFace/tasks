package com.daivcode.tasks.services;

import java.util.List;
import java.util.UUID;

import com.daivcode.tasks.domain.entities.Task;

public interface TaskService {

    List<Task> listTasks(UUID taskListId);
}
