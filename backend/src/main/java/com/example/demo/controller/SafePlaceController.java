package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SafePlace;
import com.example.demo.repository.SafePlaceRepository;

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
