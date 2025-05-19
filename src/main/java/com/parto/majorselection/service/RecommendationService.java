package com.parto.majorselection.service;

import com.parto.majorselection.model.request.RecommendationRequest;
import com.parto.majorselection.model.dto.RecommendedField;

import java.util.List;

public interface RecommendationService {
    List<RecommendedField> findRecommendations(RecommendationRequest request);
}
