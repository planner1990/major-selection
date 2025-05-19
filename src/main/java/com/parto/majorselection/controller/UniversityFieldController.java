package com.parto.majorselection.controller;

import com.parto.majorselection.model.request.UniversityFieldRequest;
import com.parto.majorselection.model.response.UniversityFieldResponse;
import com.parto.majorselection.service.UniversityFieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/university-fields")
@RequiredArgsConstructor
public class UniversityFieldController {

    private final UniversityFieldService service;

    @PostMapping
    public UniversityFieldResponse create(@RequestBody UniversityFieldRequest request) {
        return service.create(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public UniversityFieldResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<UniversityFieldResponse> list() {
        return service.listAll();
    }

    @GetMapping("/category/{category}")
    public List<UniversityFieldResponse> listByCategory(@PathVariable String category) {
        return service.listByCategory(category);
    }
}
