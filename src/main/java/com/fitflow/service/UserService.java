package com.fitflow.service;

import com.fitflow.model.dto.RegisterRequest;
import com.fitflow.model.dto.UserResponse;
import com.fitflow.model.entity.User;

public interface UserService {

    public UserResponse registerUser(RegisterRequest request);

    public UserResponse findByEmail(String email);

    User findEntityByEmail(String email);
}
