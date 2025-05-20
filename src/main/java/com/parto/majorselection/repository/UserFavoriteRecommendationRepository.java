package com.parto.majorselection.repository;

import com.parto.majorselection.model.entity.UserFavoriteRecommendation;
import com.parto.majorselection.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFavoriteRecommendationRepository extends JpaRepository<UserFavoriteRecommendation, Long> {
    List<UserFavoriteRecommendation> findByUser(User user);
    boolean existsByUserAndRecommendationResultId(User user, Long recommendationResultId);
    void deleteByUserAndRecommendationResultId(User user, Long recommendationResultId);
}
