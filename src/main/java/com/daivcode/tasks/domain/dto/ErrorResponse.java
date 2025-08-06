package com.daivcode.tasks.domain.dto;

public record ErrorResponse(
    int status,
    String message,
    String deteails
) {

}
