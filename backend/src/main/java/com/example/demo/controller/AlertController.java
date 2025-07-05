package com.example.demo.controller;

import com.example.demo.model.Alert;
import com.example.demo.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {
    @Autowired
    private AlertRepository alertRepository;

    @PostMapping("/send")
    public Alert sendAlert(@RequestBody Alert alert) {
        alert.setTimestamp(Instant.now().toString());
        return alertRepository.save(alert);
    }

    @GetMapping("/user/{userId}")
    public List<Alert> getAlertsByUser(@PathVariable String userId) {
        return alertRepository.findByUserId(userId);
    }
}
