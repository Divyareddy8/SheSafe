package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "risk_zones")
public class RiskZone {
    @Id
    private String id;
    private String name;
    private double latitude;
    private double longitude;
    private double radius; // in meters
}
