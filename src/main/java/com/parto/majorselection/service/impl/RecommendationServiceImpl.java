package com.parto.majorselection.service.impl;

import com.parto.majorselection.model.dto.RecommendationRecord;
import com.parto.majorselection.model.dto.RecommendedField;
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
    public List<RecommendedField> findRecommendations(String major, String zone, int rank) {
        return repository.loadAllRecommendations().stream()
                .filter(r -> r.getMajor().equals(major)
                        && r.getZone().equals(zone)
                        && r.getRank() >= rank)
                .findFirst()
                .map(RecommendationRecord::getResults)
                .orElse(Collections.emptyList());
    }
}
