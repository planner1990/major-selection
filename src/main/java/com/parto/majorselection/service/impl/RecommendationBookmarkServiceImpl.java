package com.parto.majorselection.service.impl;

import com.parto.majorselection.model.entity.RecommendationBookmark;
import com.parto.majorselection.model.entity.RecommendationResult;
import com.parto.majorselection.model.entity.User;
import com.parto.majorselection.repository.RecommendationBookmarkRepository;
import com.parto.majorselection.repository.RecommendationResultRepository;
import com.parto.majorselection.service.RecommendationBookmarkService;
import com.parto.majorselection.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.parto.majorselection.utils.SecurityUtils.getCurrentUser;

@Service
@RequiredArgsConstructor
public class RecommendationBookmarkServiceImpl implements RecommendationBookmarkService {

    private final RecommendationBookmarkRepository bookmarkRepository;
    private final RecommendationResultRepository resultRepository;

    @Override
    public void bookmark(Long recommendationResultId) {
        User user = getCurrentUser();
        if (bookmarkRepository.existsByUserAndRecommendationResultId(user, recommendationResultId)) return;

        RecommendationResult result = resultRepository.findById(recommendationResultId)
                .orElseThrow(() -> new RuntimeException("Result not found"));

        RecommendationBookmark bookmark = new RecommendationBookmark();
        bookmark.setUser(user);
        bookmark.setRecommendationResult(result);

        bookmarkRepository.save(bookmark);
    }

    @Override
    public void unbookmark(Long recommendationResultId) {
        User user = getCurrentUser();
        bookmarkRepository.findByUserAndRecommendationResultId(user, recommendationResultId)
                .ifPresent(bookmarkRepository::delete);
    }

    @Override
    public List<RecommendationResult> listUserBookmarks() {
        return bookmarkRepository.findByUser(getCurrentUser())
                .stream()
                .map(RecommendationBookmark::getRecommendationResult)
                .toList();
    }

}
