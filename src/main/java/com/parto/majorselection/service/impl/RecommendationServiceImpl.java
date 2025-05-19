package com.parto.majorselection.service.impl;

import com.parto.majorselection.model.dto.RecommendationRecord;
import com.parto.majorselection.model.dto.RecommendedField;
import com.parto.majorselection.model.request.RecommendationRequest;
import com.parto.majorselection.repository.json.RecommendationRepository;
import com.parto.majorselection.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

    private final RecommendationRepository repository;

    @Override
    public List<RecommendedField> findRecommendations(RecommendationRequest request) {
        return repository.loadAllRecommendations().stream()
                .filter(r -> r.getMajor().equals(request.getMajor())
                        && r.getZone().equals(request.getZone())
                        && r.getRank() >= request.getRank())
                .findFirst()
                .map(RecommendationRecord::getResults)
                .orElse(Collections.emptyList());
    }
}
