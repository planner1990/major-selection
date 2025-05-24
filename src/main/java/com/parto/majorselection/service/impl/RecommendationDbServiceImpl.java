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

        List<RecommendedField> grouped = allResults.stream()
                .filter(r -> r.getRank() >= userRank)
                .map(r -> {
                    int diff = r.getRank() - userRank;
                    String chance;
                    if (diff <= 1000) {
                        chance = "خوش‌بینانه";
                    } else if (diff <= 3000) {
                        chance = "منطقی";
                    } else {
                        chance = "بدبینانه";
                    }
                    return toDto(r, chance);
                })
                .toList();

        return new RecommendationGroupedResponse(
                limitGroup(grouped, "خوش‌بینانه", 20),
                limitGroup(grouped, "منطقی", 20),
                limitGroup(grouped, "بدبینانه", 20)
        );
    }

    private List<RecommendedField> limitGroup(List<RecommendedField> grouped, String chance, int limit) {
        return grouped.stream()
                .filter(f -> chance.equals(f.getAdmissionChance()))
                .limit(limit)
                .collect(Collectors.toList());
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
