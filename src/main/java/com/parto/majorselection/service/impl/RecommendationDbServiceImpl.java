package com.parto.majorselection.service.impl;

import com.parto.majorselection.model.dto.RecommendedField;
import com.parto.majorselection.model.entity.RecommendationResult;
import com.parto.majorselection.model.request.RecommendationRequest;
import com.parto.majorselection.model.response.RecommendationGroupedResponse;
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
    public RecommendationGroupedResponse findRecommendations(RecommendationRequest request) {
        int userRank = request.getRank();

        List<RecommendationResult> allResults = repository.findAllByMajorAndZone(
                request.getMajor(), request.getZone());

        List<RecommendedField> optimistic = allResults.stream()
                .filter(r -> userRank - r.getRank() < 1000)
                .limit(20)
                .map(r -> toDto(r, "خوش‌بینانه"))
                .collect(Collectors.toList());

        List<RecommendedField> realistic = allResults.stream()
                .filter(r -> userRank - r.getRank() >= 1000 && userRank - r.getRank() < 3000)
                .limit(20)
                .map(r -> toDto(r, "منطقی"))
                .collect(Collectors.toList());

        List<RecommendedField> pessimistic = allResults.stream()
                .filter(r -> userRank - r.getRank() >= 3000)
                .limit(20)
                .map(r -> toDto(r, "بدبینانه"))
                .collect(Collectors.toList());

        return new RecommendationGroupedResponse(optimistic, realistic, pessimistic);
    }

    private RecommendedField toDto(RecommendationResult result, String chance) {
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
        dto.setAdmissionChance(chance);
        return dto;
    }
}
