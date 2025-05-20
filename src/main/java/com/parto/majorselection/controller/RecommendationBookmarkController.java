package com.parto.majorselection.controller;

import com.parto.majorselection.model.entity.RecommendationResult;
import com.parto.majorselection.service.RecommendationBookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation-bookmarks")
@RequiredArgsConstructor
public class RecommendationBookmarkController {

    private final RecommendationBookmarkService bookmarkService;

    @PostMapping("/{id}")
    public void bookmark(@PathVariable Long id) {
        bookmarkService.bookmark(id);
    }

    @DeleteMapping("/{id}")
    public void unbookmark(@PathVariable Long id) {
        bookmarkService.unbookmark(id);
    }

    @GetMapping
    public List<RecommendationResult> getBookmarks() {
        return bookmarkService.listUserBookmarks();
    }
}
