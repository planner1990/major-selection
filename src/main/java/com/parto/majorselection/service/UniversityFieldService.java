package com.parto.majorselection.service;

import com.parto.majorselection.model.request.UniversityFieldRequest;
import com.parto.majorselection.model.response.UniversityFieldResponse;

import java.util.List;

public interface UniversityFieldService {

    UniversityFieldResponse create(UniversityFieldRequest request);

    void delete(Long id);

    UniversityFieldResponse get(Long id);

    List<UniversityFieldResponse> listAll();

    List<UniversityFieldResponse> listByCategory(String category);
}
