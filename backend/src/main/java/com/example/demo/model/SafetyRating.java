package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "safety_ratings")
public class SafetyRating {
    @Id
    private String id;
    private String userId;
    private double latitude;
    private double longitude;
    private int rating; // 1–5
    private String comment;
}
