package com.parto.majorselection.service.impl;

import com.parto.majorselection.model.entity.UniversityField;
import com.parto.majorselection.model.entity.UniversityFieldBookmark;
import com.parto.majorselection.model.entity.User;
import com.parto.majorselection.model.response.UniversityFieldResponse;
import com.parto.majorselection.repository.UniversityFieldBookmarkRepository;
import com.parto.majorselection.repository.UniversityFieldRepository;
import com.parto.majorselection.service.UniversityFieldBookmarkService;
import com.parto.majorselection.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UniversityFieldBookmarkServiceImpl implements UniversityFieldBookmarkService {

    private final UniversityFieldRepository fieldRepository;
    private final UniversityFieldBookmarkRepository bookmarkRepository;

    @Override
    public void bookmark(Long universityFieldId) {
        User user = SecurityUtils.getCurrentUser();
        UniversityField field = fieldRepository.findById(universityFieldId)
                .orElseThrow(() -> new RuntimeException("Not found"));

        if (!bookmarkRepository.existsByUserAndUniversityField(user, field)) {
            UniversityFieldBookmark bookmark = new UniversityFieldBookmark();
            bookmark.setUser(user);
            bookmark.setUniversityField(field);
            bookmarkRepository.save(bookmark);
        }
    }

    @Override
    public void unbookmark(Long universityFieldId) {
        User user = SecurityUtils.getCurrentUser();
        UniversityField field = fieldRepository.findById(universityFieldId)
                .orElseThrow(() -> new RuntimeException("Not found"));

        bookmarkRepository.findByUserAndUniversityField(user, field)
                .ifPresent(bookmarkRepository::delete);
    }

    @Override
    public List<UniversityFieldResponse> listUserBookmarks() {
        User user = SecurityUtils.getCurrentUser();
        return bookmarkRepository.findByUser(user).stream()
                .map(b -> toResponse(b.getUniversityField()))
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

