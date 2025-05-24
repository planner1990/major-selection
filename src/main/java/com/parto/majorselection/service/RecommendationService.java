package com.parto.majorselection.service;

import com.parto.majorselection.model.request.RecommendationRequest;
import com.parto.majorselection.model.response.RecommendationGroupedResponse;

public interface RecommendationService {
    RecommendationGroupedResponse findRecommendations(RecommendationRequest request);
}
