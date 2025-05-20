package com.parto.majorselection.service;

import com.parto.majorselection.model.response.UniversityFieldResponse;

import java.util.List;

public interface UniversityFieldBookmarkService {

    void bookmark(Long universityFieldId);

    void unbookmark(Long universityFieldId);

    List<UniversityFieldResponse> listUserBookmarks();
}

