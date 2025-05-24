package com.parto.majorselection.service.impl;

import com.parto.majorselection.model.request.UniversityFieldRequest;
import com.parto.majorselection.model.response.UniversityFieldResponse;
import com.parto.majorselection.model.entity.UniversityField;
import com.parto.majorselection.repository.UniversityFieldRepository;
import com.parto.majorselection.service.UniversityFieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UniversityFieldServiceImpl implements UniversityFieldService {

    private final UniversityFieldRepository repository;

    @Override
    public UniversityFieldResponse create(UniversityFieldRequest request) {
        UniversityField field = new UniversityField();
        field.setHighSchoolCategory(request.getHighSchoolCategory());
        field.setTitle(request.getTitle());
        field.setIntro(request.getIntro());
        field.setSubField(request.getSubField());
        field.setVision(request.getVision());
        field.setLessons(request.getLessons());
        field.setJobSituation(request.getJobSituation());

        return toResponse(repository.save(field));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UniversityFieldResponse get(Long id) {
        UniversityField field = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return toResponse(field);
    }

    @Override
    public List<UniversityFieldResponse> listAll() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<UniversityFieldResponse> listByCategory(String category) {
        return repository.findByHighSchoolCategoryContainingIgnoreCase(category).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private UniversityFieldResponse toResponse(UniversityField field) {
        UniversityFieldResponse response = new UniversityFieldResponse();
        response.setId(field.getId());
        response.setHighSchoolCategory(field.getHighSchoolCategory());
        response.setTitle(field.getTitle());
        response.setIntro(field.getIntro());
        response.setSubField(field.getSubField());
        response.setVision(field.getVision());
        response.setLessons(field.getLessons());
        response.setJobSituation(field.getJobSituation());
        return response;
    }
}
