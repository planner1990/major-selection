package com.parto.majorselection.repository;

import com.parto.majorselection.model.entity.RecommendationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationResultRepository extends JpaRepository<RecommendationResult, Long> {
    List<RecommendationResult> findAllByMajorAndZone(String major, String zone);

}
