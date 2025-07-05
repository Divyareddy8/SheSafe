package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "safe_places")
public class SafePlace {
    @Id
    private String id;
    private String name;
    private String type; // e.g., "Police Station", "Hospital"
    private double latitude;
    private double longitude;
    private String contactInfo;
}
