package com.fitflow.advices;

import com.fitflow.exception.ResourceAlreadyExistsException;
import com.fitflow.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFound(ResourceNotFoundException exception){
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ApiError> handleResourceAlreadyExist(ResourceAlreadyExistsException exception){
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.CONFLICT)
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneric(Exception exception){
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
