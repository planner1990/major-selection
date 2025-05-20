package com.parto.majorselection.service.impl;

import com.parto.majorselection.model.dto.RecommendedField;
import com.parto.majorselection.model.entity.RecommendationResult;
import com.parto.majorselection.model.request.RecommendationRequest;
import com.parto.majorselection.repository.RecommendationResultRepository;
import com.parto.majorselection.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Primary
@Service
@RequiredArgsConstructor
public class RecommendationDbServiceImpl implements RecommendationService {

    private final RecommendationResultRepository repository;

    @Override
    public List<RecommendedField> findRecommendations(RecommendationRequest request) {
        return repository.findAllByMajorAndZoneAndRankGreaterThanEqual(
                        request.getMajor(), request.getZone(), request.getRank()
                ).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private RecommendedField toDto(RecommendationResult result) {
        RecommendedField dto = new RecommendedField();
        dto.setId(result.getId());
        dto.setSahmie(result.getSahmie());
        dto.setReshte(result.getReshte());
        dto.setDaneshgah(result.getDaneshgah());
        dto.setOstan(result.getOstan());
        dto.setDore(result.getDore());
        dto.setRankCountry(result.getRankCountry());
        dto.setRankZone(result.getRankZone());
        dto.setCity(result.getCity());
        return dto;
    }
}
