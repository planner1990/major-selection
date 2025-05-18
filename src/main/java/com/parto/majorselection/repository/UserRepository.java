package com.parto.majorselection.repository;

import com.parto.majorselection.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByMobile(String mobile);
    boolean existsByMobile(String mobile);
}
