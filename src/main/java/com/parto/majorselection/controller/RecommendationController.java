package com.parto.majorselection.controller;

import com.parto.majorselection.model.request.RecommendationRequest;
import com.parto.majorselection.model.response.BaseResponse;
import com.parto.majorselection.model.response.RecommendationGroupedResponse;
import com.parto.majorselection.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping
    public BaseResponse<RecommendationGroupedResponse> getRecommendations(@ModelAttribute RecommendationRequest request) {
        RecommendationGroupedResponse response = recommendationService.findRecommendations(request);
        return new BaseResponse<>(true, "Recommendations fetched successfully", response);
    }
}
