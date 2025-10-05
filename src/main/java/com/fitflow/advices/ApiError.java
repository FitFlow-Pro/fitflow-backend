package com.fitflow.advices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ApiError {
    private HttpStatus status;
    private String message;
    private LocalDateTime timestamp;

    public ApiError(HttpStatus status, String message){
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
