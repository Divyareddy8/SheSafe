package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RiskZone;
import com.example.demo.repository.RiskZoneRepository;
import com.example.demo.service.GeoFenceService;

@RestController
@RequestMapping("/api/risk_zones")
public class RiskZoneController {
    private final RiskZoneRepository riskZoneRepository;
    private final GeoFenceService geoFenceService;

    @Autowired
    public RiskZoneController(RiskZoneRepository riskZoneRepository, GeoFenceService geoFenceService) {
        this.riskZoneRepository = riskZoneRepository;
        this.geoFenceService = geoFenceService;
    }

    @PostMapping
    public RiskZone add(@RequestBody RiskZone riskZone) {
        return riskZoneRepository.save(riskZone);
    }

    @GetMapping
    public List<RiskZone> getAll() {
        return riskZoneRepository.findAll();
    }

    @GetMapping("/check")
    public ResponseEntity<Boolean> checkLocation(@RequestParam double lat, @RequestParam double lng) {
        boolean inside = geoFenceService.isInsideRiskZone(lat, lng);
        return ResponseEntity.ok(inside);
    }
}
