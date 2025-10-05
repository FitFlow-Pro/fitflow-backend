package com.fitflow.service.impl;

import com.fitflow.exception.ResourceAlreadyExistsException;
import com.fitflow.exception.ResourceNotFoundException;
import com.fitflow.model.dto.RegisterRequest;
import com.fitflow.model.dto.UserResponse;
import com.fitflow.model.entity.User;
import com.fitflow.repository.UserRepository;
import com.fitflow.service.UserService;
import com.fitflow.util.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserResponse registerUser(RegisterRequest request) {
//        Check if user already exists
        if (userRepository.existsByEmail(request.getEmail())){
            throw new ResourceAlreadyExistsException("USER_ALREADY_EXISTS");
        }

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public UserResponse findByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("USER_NOT_FOUND" + email));
        return userMapper.toResponse(user);
    }

    @Override
    public User findEntityByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("USER_NOT_FOUND"));
    }
}
