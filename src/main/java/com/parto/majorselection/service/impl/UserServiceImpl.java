package com.parto.majorselection.service.impl;

import com.parto.majorselection.model.dto.UserLoginResponse;
import com.parto.majorselection.model.entity.User;
import com.parto.majorselection.model.request.UserLoginRequest;
import com.parto.majorselection.model.request.UserRegisterRequest;
import com.parto.majorselection.model.response.UserResponse;
import com.parto.majorselection.repository.UserRepository;
import com.parto.majorselection.security.JwtService;
import com.parto.majorselection.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public UserResponse register(UserRegisterRequest request) {
        if (userRepository.existsByMobile(request.getMobile())) {
            throw new RuntimeException("شماره موبایل قبلاً ثبت شده است.");
        }

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .mobile(request.getMobile())
                .password(passwordEncoder.encode(request.getPassword()))
                .highSchoolMajor(request.getHighSchoolMajor())
                .city(request.getCity())
                .build();

        return toUserResponse(userRepository.save(user));
    }

    @Override
    public UserLoginResponse login(UserLoginRequest request) {
        User user = userRepository.findByMobile(request.getMobile())
                .orElseThrow(() -> new RuntimeException("کاربری با این شماره یافت نشد."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("رمز عبور اشتباه است.");
        }

        String token = jwtService.generateToken(user.getMobile());

        return UserLoginResponse.builder()
                .token(token)
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .mobile(user.getMobile())
                .highSchoolMajor(user.getHighSchoolMajor())
                .city(user.getCity())
                .build();
    }

    private UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .mobile(user.getMobile())
                .highSchoolMajor(user.getHighSchoolMajor())
                .city(user.getCity())
                .build();
    }
}
