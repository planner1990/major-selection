package com.parto.majorselection.repository;

import com.parto.majorselection.model.entity.RecommendationResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationResultRepository extends JpaRepository<RecommendationResult, Long> {
    List<RecommendationResult> findByMajorAndZoneAndRankLessThanEqual(String major, String zone, int rank);
}
