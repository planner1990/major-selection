package com.parto.majorselection.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserLoginResponse {
    private String token;
    private String firstName;
    private String lastName;
    private String mobile;
    private String highSchoolMajor;
    private String city;
}
