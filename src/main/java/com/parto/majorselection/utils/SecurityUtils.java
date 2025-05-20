package com.parto.majorselection.utils;

import com.parto.majorselection.model.entity.User;
import com.parto.majorselection.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !(authentication.getPrincipal() instanceof UserDetailsImpl)) {
            throw new RuntimeException("User is not authenticated");
        }

        return ((UserDetailsImpl) authentication.getPrincipal()).getUser();
    }
}
