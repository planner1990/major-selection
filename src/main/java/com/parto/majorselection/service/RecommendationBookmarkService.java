package com.parto.majorselection.service;

import com.parto.majorselection.model.entity.RecommendationResult;

import java.util.List;

public interface RecommendationBookmarkService {

    void bookmark(Long recommendationResultId);

    void unbookmark(Long recommendationResultId);

    List<RecommendationResult> listUserBookmarks();
}
