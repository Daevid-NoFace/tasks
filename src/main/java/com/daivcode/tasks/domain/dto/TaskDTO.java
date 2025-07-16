package com.daivcode.tasks.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.daivcode.tasks.domain.entities.Task;
import com.daivcode.tasks.domain.entities.TaskPriority;
import com.daivcode.tasks.domain.entities.TaskStatus;

public record TaskDTO(

    UUID id,
    String title,
    String description,
    LocalDateTime dueDate,
    TaskStatus status,
    TaskPriority priority
) {
}
