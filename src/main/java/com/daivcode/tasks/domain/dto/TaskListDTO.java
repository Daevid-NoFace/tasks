package com.daivcode.tasks.domain.dto;

import java.util.List;
import java.util.UUID;

public record TaskListDTO(

    UUID id,
    String tittle,
    String description,
    Integer count,
    Double progress,
    List<TaskDTO> tasks
) {

}
