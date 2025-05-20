package com.parto.majorselection.bootstrap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.parto.majorselection.config.RecommendationProperties;
import com.parto.majorselection.model.dto.RecommendationRecord;
import com.parto.majorselection.model.dto.RecommendedField;
import com.parto.majorselection.model.entity.RecommendationResult;
import com.parto.majorselection.repository.RecommendationResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RecommendationImporter implements CommandLineRunner {

    private final RecommendationResultRepository repository;
    private final RecommendationProperties properties;

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() > 0) return;

        List<RecommendationResult> entities = loadAndTransformData();
        repository.saveAll(entities);

        System.out.println("✅ Imported " + entities.size() + " rows.");
    }

    private List<RecommendationResult> loadAndTransformData() throws Exception {
        List<RecommendationRecord> records = readJsonFile(properties.getFilePath());
        List<RecommendationResult> results = new ArrayList<>();

        for (RecommendationRecord record : records) {
            for (RecommendedField field : record.getResults()) {
                results.add(toEntity(record, field));
            }
        }

        return results;
    }

    private List<RecommendationRecord> readJsonFile(String path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(path);
        return mapper.readValue(file, new TypeReference<>() {
        });
    }

    private RecommendationResult toEntity(RecommendationRecord record, RecommendedField field) {
        RecommendationResult entity = new RecommendationResult();
        entity.setMajor(record.getMajor());
        entity.setZone(record.getZone());
        entity.setRank(record.getRank());

        entity.setSahmie(field.getSahmie());
        entity.setReshte(field.getReshte());
        entity.setDaneshgah(field.getDaneshgah());
        entity.setOstan(field.getOstan());
        entity.setDore(field.getDore());
        entity.setRankCountry(field.getRankCountry());
        entity.setRankZone(field.getRankZone());
        entity.setCity(field.getCity());

        return entity;
    }
}
