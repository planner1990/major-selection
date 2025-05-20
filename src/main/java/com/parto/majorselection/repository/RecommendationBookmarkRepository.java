package com.parto.majorselection.repository;

import com.parto.majorselection.model.entity.RecommendationBookmark;
import com.parto.majorselection.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecommendationBookmarkRepository extends JpaRepository<RecommendationBookmark, Long> {

    List<RecommendationBookmark> findByUser(User user);

    boolean existsByUserAndRecommendationResultId(User user, Long recommendationResultId);

    Optional<RecommendationBookmark> findByUserAndRecommendationResultId(User user, Long recommendationResultId);
}
