package com.fitflow.util;

import com.fitflow.model.dto.RegisterRequest;
import com.fitflow.model.dto.UserResponse;
import com.fitflow.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "role", expression = "java(request.getRole() != null ? request.getRole() : UserRole.MEMBER)")
    User toEntity(RegisterRequest request);

    UserResponse toResponse(User user);
}
