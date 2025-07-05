package com.example.demo.controller;

import com.example.demo.model.SafetyRating;
import com.example.demo.repository.SafetyRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
