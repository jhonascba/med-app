package com.lightbringer.medapp.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ValueNotFoundException.class)
    public ResponseEntity handleValueNotFound(ValueNotFoundException ex) {
        String errorMessage = "VALUE NOT FOUND!";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handleBadRequest(IllegalArgumentException ex) {
        String message = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse("BAD REQUEST", message);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
