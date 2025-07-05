package com.example.demo.repository;

import com.example.demo.model.SafePlace;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SafePlaceRepository extends MongoRepository<SafePlace, String> {
}
