package com.example.demo.controller;

import com.example.demo.model.SafePlace;
import com.example.demo.repository.SafePlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/safe_places")
public class SafePlaceController {
    @Autowired
    private SafePlaceRepository safePlaceRepository;

    @PostMapping
    public SafePlace add(@RequestBody SafePlace safePlace) {
        return safePlaceRepository.save(safePlace);
    }

    @GetMapping
    public List<SafePlace> getAll() {
        return safePlaceRepository.findAll();
    }
}
