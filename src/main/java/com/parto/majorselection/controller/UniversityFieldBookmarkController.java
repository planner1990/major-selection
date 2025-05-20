package com.parto.majorselection.controller;

import com.parto.majorselection.model.response.UniversityFieldResponse;
import com.parto.majorselection.service.UniversityFieldBookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/university-field-bookmarks")
@RequiredArgsConstructor
public class UniversityFieldBookmarkController {

    private final UniversityFieldBookmarkService bookmarkService;

    @PostMapping("/{id}")
    public void bookmark(@PathVariable Long id) {
        bookmarkService.bookmark(id);
    }

    @DeleteMapping("/{id}")
    public void unbookmark(@PathVariable Long id) {
        bookmarkService.unbookmark(id);
    }

    @GetMapping
    public List<UniversityFieldResponse> listBookmarks() {
        return bookmarkService.listUserBookmarks();
    }
}

