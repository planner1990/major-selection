package com.parto.majorselection.controller;

import com.parto.majorselection.model.dto.UserLoginResponse;
import com.parto.majorselection.model.entity.User;
import com.parto.majorselection.model.request.UserLoginRequest;
import com.parto.majorselection.model.request.UserRegisterRequest;
import com.parto.majorselection.model.response.UserResponse;
import com.parto.majorselection.security.UserDetailsImpl;
import com.parto.majorselection.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public UserLoginResponse login(@RequestBody UserLoginRequest request) {
        return userService.login(request);
    }

    @GetMapping("/me")
    public UserResponse getCurrentUser(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();

        return UserResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .mobile(user.getMobile())
                .highSchoolMajor(user.getHighSchoolMajor())
                .city(user.getCity())
                .build();
    }

}
