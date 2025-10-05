package com.fitflow.model.dto;

import com.fitflow.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String email;
    private UserRole role;
    private LocalDateTime createdAt;
}
