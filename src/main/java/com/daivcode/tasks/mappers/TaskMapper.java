package com.daivcode.tasks.mappers;

import com.daivcode.tasks.domain.dto.TaskDTO;
import com.daivcode.tasks.domain.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDTO taskDto);

    TaskDTO toDto(Task task);
}
