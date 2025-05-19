package com.parto.majorselection.service;

import com.parto.majorselection.model.dto.UserLoginResponse;
import com.parto.majorselection.model.request.UserLoginRequest;
import com.parto.majorselection.model.request.UserRegisterRequest;
import com.parto.majorselection.model.response.UserResponse;

public interface UserService {
    UserResponse register(UserRegisterRequest request);
    UserLoginResponse login(UserLoginRequest request);
}
