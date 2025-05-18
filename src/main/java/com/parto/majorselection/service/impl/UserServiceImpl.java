package com.parto.majorselection.service.impl;

import com.parto.majorselection.model.entity.User;
import com.parto.majorselection.model.request.UserLoginRequest;
import com.parto.majorselection.model.request.UserRegisterRequest;
import com.parto.majorselection.model.response.UserResponse;
import com.parto.majorselection.repository.UserRepository;
import com.parto.majorselection.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse register(UserRegisterRequest request) {
        if (userRepository.existsByMobile(request.getMobile())) {
            throw new RuntimeException("شماره موبایل قبلاً ثبت شده است.");
        }

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setMobile(request.getMobile());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setHighSchoolMajor(request.getHighSchoolMajor());
        user.setCity(request.getCity());

        user = userRepository.save(user);

        return toResponse(user);
    }

    @Override
    public UserResponse login(UserLoginRequest request) {
        User user = userRepository.findByMobile(request.getMobile())
                .orElseThrow(() -> new RuntimeException("کاربری با این شماره یافت نشد."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("رمز عبور اشتباه است.");
        }

        return toResponse(user);
    }

    private UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .mobile(user.getMobile())
                .highSchoolMajor(user.getHighSchoolMajor())
                .city(user.getCity())
                .build();
    }
}
