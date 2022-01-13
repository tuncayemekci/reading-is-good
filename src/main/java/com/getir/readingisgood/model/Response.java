package com.getir.readingisgood.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
public class Response {

    private LocalDateTime timestamp;
    private int statusCode;
    private String response;
    private String message;
    private Object payload;

    public static ResponseEntity<Response> OK(Object payload) {
        Response response = Response.builder()
                                    .timestamp(LocalDateTime.now())
                                    .statusCode(HttpStatus.OK.value())
                                    .response(HttpStatus.OK.getReasonPhrase())
                                    .payload(payload)
                                    .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static ResponseEntity<Response> OK(Object payload, String message) {
        Response response = Response.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(HttpStatus.OK.value())
                .response(HttpStatus.OK.getReasonPhrase())
                .message(message)
                .payload(payload)
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static ResponseEntity<Response> OK(String message) {
        Response response = Response.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(HttpStatus.OK.value())
                .response(HttpStatus.OK.getReasonPhrase())
                .message(message)
                .payload(new ArrayList<>())
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static ResponseEntity<Response> CREATED(Object payload) {
        Response response = Response.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(HttpStatus.CREATED.value())
                .response(HttpStatus.CREATED.getReasonPhrase())
                .payload(payload)
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public static ResponseEntity<Response> CREATED(Object payload, String message) {
        Response response = Response.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(HttpStatus.CREATED.value())
                .response(HttpStatus.CREATED.getReasonPhrase())
                .message(message)
                .payload(payload)
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public static ResponseEntity<Response> CREATED(String message) {
        Response response = Response.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(HttpStatus.CREATED.value())
                .response(HttpStatus.CREATED.getReasonPhrase())
                .message(message)
                .payload(new ArrayList<>())
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
