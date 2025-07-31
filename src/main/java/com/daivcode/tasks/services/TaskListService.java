package com.daivcode.tasks.services;

import java.util.List;
import com.daivcode.tasks.domain.entities.TaskList;

public interface TaskListService {

    List<TaskList> listTaskLists();
    
    TaskList createTaskList(TaskList taskList);
}
