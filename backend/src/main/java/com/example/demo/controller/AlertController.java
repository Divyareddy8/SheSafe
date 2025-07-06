package com.example.demo.controller;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Alert;
import com.example.demo.repository.AlertRepository;
import com.example.demo.service.AlertService;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {
    private final AlertRepository alertRepository;
    private final AlertService alertService;

    @Autowired
    public AlertController(AlertRepository alertRepository, AlertService alertService) {
        this.alertRepository = alertRepository;
        this.alertService = alertService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendAlert(@RequestBody Alert alert, @RequestParam String phone) {
        alert.setTimestamp(Instant.now().toString());
        alertService.saveAlert(alert);
        alertService.sendSms(
                phone,
                "Emergency! The user needs help at: Latitude " + alert.getLatitude() +
                ", Longitude " + alert.getLongitude()
        );
        return ResponseEntity.ok("Alert sent and saved successfully.");
    }

    @GetMapping("/user/{userId}")
    public List<Alert> getAlertsByUser(@PathVariable String userId) {
        return alertRepository.findByUserId(userId);
    }
}
