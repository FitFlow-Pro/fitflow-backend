package com.fitflow.service.impl;

import com.fitflow.model.dto.AuthResponse;
import com.fitflow.model.dto.LoginRequest;
import com.fitflow.model.dto.RegisterRequest;
import com.fitflow.model.dto.UserResponse;
import com.fitflow.model.entity.Member;
import com.fitflow.model.entity.User;
import com.fitflow.model.enums.UserRole;
import com.fitflow.repository.MemberRepository;
import com.fitflow.service.AuthService;
import com.fitflow.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthResponseImpl implements AuthService {

    private final UserService userService;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse register(RegisterRequest request) {
        // Register user (returns DTO)
        UserResponse user = userService.registerUser(request);

        // If user is MEMBER, create member profile (using internal entity method)
        if (user.getRole() == UserRole.MEMBER){
            User userEntity = userService.findEntityByEmail(user.getEmail());

            Member member = new Member();
            member.setUser(userEntity);
            member.setFirstName(request.getFirstName());
            member.setLastName(request.getLastName());
            memberRepository.save(member);
        }

        String token = "temp-token-" + user.getId();

        return new AuthResponse(token,
                user.getEmail(),
                user.getRole(),
                "User registered successfully!"
        );
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
