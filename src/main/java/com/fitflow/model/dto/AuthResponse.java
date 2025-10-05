package com.fitflow.model.dto;

import com.fitflow.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    private String token;
    private String email;
    private UserRole userRole;
    private String message;
}
