package com.daivcode.tasks.mappers.impl;

import org.springframework.stereotype.Component;

import com.daivcode.tasks.domain.dto.TaskDTO;
import com.daivcode.tasks.domain.entities.Task;
import com.daivcode.tasks.mappers.TaskMapper;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task fromDto(TaskDTO taskDto) {
        // TODO Auto-generated method stub
        return new Task(
            taskDto.id(),
            taskDto.title(),
            taskDto.description(),
            taskDto.dueDate(),
            taskDto.priority(),
            null, // Assuming taskList is not provided in TaskDTO
            taskDto.status(),
            null,
            null
        );
    }

    @Override
    public TaskDTO toDto(Task task) {
        // TODO Auto-generated method stub
        return new TaskDTO(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getDueDate(),
            task.getStatus(),
            task.getPriority()
        );
    }


}
