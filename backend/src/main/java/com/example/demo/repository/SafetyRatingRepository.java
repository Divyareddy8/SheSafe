package com.example.demo.repository;

import com.example.demo.model.SafetyRating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SafetyRatingRepository extends MongoRepository<SafetyRating, String> {
    List<SafetyRating> findByLatitudeAndLongitude(double latitude, double longitude);
}
