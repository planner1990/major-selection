package com.parto.majorselection.repository;

import com.parto.majorselection.model.entity.UniversityField;
import com.parto.majorselection.model.entity.UniversityFieldBookmark;
import com.parto.majorselection.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UniversityFieldBookmarkRepository extends JpaRepository<UniversityFieldBookmark, Long> {

    boolean existsByUserAndUniversityField(User user, UniversityField field);

    Optional<UniversityFieldBookmark> findByUserAndUniversityField(User user, UniversityField field);

    List<UniversityFieldBookmark> findByUser(User user);
}

