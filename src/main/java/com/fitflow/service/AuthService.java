package com.fitflow.service;

import com.fitflow.model.dto.AuthResponse;
import com.fitflow.model.dto.LoginRequest;
import com.fitflow.model.dto.RegisterRequest;

public interface AuthService {

    public AuthResponse register(RegisterRequest request);

    public AuthResponse login(LoginRequest request);
}
