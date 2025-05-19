package com.parto.majorselection.controller;

import com.parto.majorselection.model.dto.RecommendedField;
import com.parto.majorselection.model.request.RecommendationRequest;
import com.parto.majorselection.model.response.BaseResponse;
import com.parto.majorselection.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping
    public BaseResponse<List<RecommendedField>> getRecommendations(@ModelAttribute RecommendationRequest request) {
        List<RecommendedField> results = recommendationService.findRecommendations(request);
        return new BaseResponse<>(true, "Recommendations fetched successfully", results);
    }


}
