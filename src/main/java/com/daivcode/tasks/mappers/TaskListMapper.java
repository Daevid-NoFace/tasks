package com.daivcode.tasks.mappers;

import com.daivcode.tasks.domain.dto.TaskListDto;
import com.daivcode.tasks.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);
}
