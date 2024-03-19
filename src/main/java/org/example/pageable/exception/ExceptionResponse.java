package org.example.pageable.exception;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class ExceptionResponse {

    private String message;

    private LocalDateTime localDateTime;
}
