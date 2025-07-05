package com.example.demo.repository;

import com.example.demo.model.Alert;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AlertRepository extends MongoRepository<Alert, String> {
    List<Alert> findByUserId(String userId);
}
