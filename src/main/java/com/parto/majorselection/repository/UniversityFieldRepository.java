package com.parto.majorselection.repository;

import com.parto.majorselection.model.entity.UniversityField;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniversityFieldRepository extends JpaRepository<UniversityField, Long> {
    List<UniversityField> findByHighSchoolCategory(String highSchoolCategory);
}

