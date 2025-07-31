package com.daivcode.tasks.mappers;

import com.daivcode.tasks.domain.dto.TaskDto;
import com.daivcode.tasks.domain.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}
