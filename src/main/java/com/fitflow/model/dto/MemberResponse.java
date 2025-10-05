package com.fitflow.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private LocalDate joinDate;
}
