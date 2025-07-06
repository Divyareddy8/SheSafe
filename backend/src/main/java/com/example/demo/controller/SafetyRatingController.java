package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SafetyRating;
import com.example.demo.repository.SafetyRatingRepository;

@RestController
@RequestMapping("/api/ratings")
public class SafetyRatingController {
    @Autowired
    private SafetyRatingRepository safetyRatingRepository;

    @PostMapping("/submit")
    public SafetyRating submit(@RequestBody SafetyRating rating) {
        return safetyRatingRepository.save(rating);
    }

    @GetMapping("/average")
    public double average(@RequestParam double latitude, @RequestParam double longitude) {
        List<SafetyRating> ratings = safetyRatingRepository.findByLatitudeAndLongitude(latitude, longitude);
        if (ratings.isEmpty()) return 0;
        return ratings.stream().mapToInt(SafetyRating::getRating).average().orElse(0);
    }
}
