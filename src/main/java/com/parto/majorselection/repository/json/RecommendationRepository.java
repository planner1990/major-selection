package com.parto.majorselection.repository.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.parto.majorselection.config.RecommendationProperties;
import com.parto.majorselection.model.dto.RecommendationRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RecommendationRepository {

    private final ObjectMapper objectMapper;
    private final RecommendationProperties properties;

    public List<RecommendationRecord> loadAllRecommendations() {
        try {
            File file = new File(properties.getFilePath());
            return objectMapper.readValue(file, new TypeReference<>() {
            });
        } catch (Exception e) {
            throw new RuntimeException("Failed to load recommendation data", e);
        }
    }
}
