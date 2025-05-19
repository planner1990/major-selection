package com.parto.majorselection.bootstrap;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.parto.majorselection.model.entity.UniversityField;
import com.parto.majorselection.repository.UniversityFieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class UniversityFieldJsonLoader implements CommandLineRunner {

    private final UniversityFieldRepository repository;

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() > 0) return;

        ObjectMapper mapper = new ObjectMapper();

        Map<String, String> fileToCategory = Map.of(
                "art.json", "هنر",
                "experiment.json", "تجربی",
                "human.json", "علوم انسانی",
                "islamic.json", "علوم اسلامی و قرآن",
                "language.json", "زبان‌های خارجه",
                "math.json", "ریاضی فیزیک",
                "professional-technical.json", "فنی و حرفه‌ای",
                "work-and-knowledge.json", "کار و دانش"
        );

        for (Map.Entry<String, String> entry : fileToCategory.entrySet()) {
            String fileName = entry.getKey();
            String category = entry.getValue();

            InputStream is = new ClassPathResource("data/" + fileName).getInputStream();
            JsonNode root = mapper.readTree(is);

            for (JsonNode node : root.get("body")) {
                UniversityField field = new UniversityField();
                field.setHighSchoolCategory(category);
                field.setTitle(node.get("title").asText());
                field.setIntro(node.get("intro").asText());
                field.setSubField(node.get("subField").asText());
                field.setVision(node.get("vision").asText());
                field.setLessons(node.get("lessons").asText());
                field.setJobSituation(node.get("jobSituation").asText());

                repository.save(field);
            }
        }
    }
}
