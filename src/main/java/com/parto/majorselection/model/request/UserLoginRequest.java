package com.parto.majorselection.model.request;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String mobile;
    private String password;
}
