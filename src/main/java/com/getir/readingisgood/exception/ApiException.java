package com.getir.readingisgood.exception;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ApiException {

    private final LocalDateTime timestamp;
    private final int statusCode;
    private final String error;
    private final String message;

}
