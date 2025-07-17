package com.daivcode.tasks.mappers;

import com.daivcode.tasks.domain.dto.TaskListDTO;
import com.daivcode.tasks.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDTO taskListDto);

    TaskListDTO toDto(TaskList taskList);
}
