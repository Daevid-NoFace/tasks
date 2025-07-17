package com.daivcode.tasks.mappers.impl;

import com.daivcode.tasks.mappers.TaskListMapper;
import com.daivcode.tasks.mappers.TaskMapper;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.daivcode.tasks.domain.dto.TaskListDTO;
import com.daivcode.tasks.domain.entities.Task;
import com.daivcode.tasks.domain.entities.TaskList;
import com.daivcode.tasks.domain.entities.TaskStatus;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDTO taskListDto) {
        // TODO Auto-generated method stub
        return new TaskList(
            taskListDto.id(),
            taskListDto.tittle(),
            taskListDto.description(),
            Optional.ofNullable(taskListDto.tasks()).map(tasks -> tasks.stream().map(taskMapper::fromDto).toList()).orElse(null),
            null,
            null
        );
    }

    @Override
    public TaskListDTO toDto(TaskList taskList) {
        // TODO Auto-generated method stub
        return new TaskListDTO(
            taskList.getId(),
            taskList.getTittle(),
            taskList.getDescription(),
            Optional.ofNullable(taskList.getTasks()).map(List::size).orElse(0),
            calculateProgress(taskList.getTasks()),
            Optional.ofNullable(taskList.getTasks())
                .map(tasks -> tasks.stream().map(taskMapper::toDto).toList())
                .orElse(null)
            
        );
    }

    private Double calculateProgress(List<Task> taskList) {
        if (taskList == null || taskList.isEmpty()) {
            return 0.0;
        }

        long completedTasks = taskList.stream().filter(task -> TaskStatus.CLOSE == task.getStatus()).count();
        return completedTasks * 100.0 / taskList.size();
    }
}
