package com.example.demo.repository;

import com.example.demo.model.RiskZone;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RiskZoneRepository extends MongoRepository<RiskZone, String> {
}
