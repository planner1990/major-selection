package com.parto.majorselection.model.request;

import lombok.Data;

@Data
public class UserRegisterRequest {
    private String firstName;
    private String lastName;
    private String mobile;
    private String password;
    private String highSchoolMajor;
    private String city;
}
