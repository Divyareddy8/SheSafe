package com.example.demo.controller;

import com.example.demo.model.RiskZone;
import com.example.demo.repository.RiskZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk_zones")
public class RiskZoneController {
    @Autowired
    private RiskZoneRepository riskZoneRepository;

    @PostMapping
    public RiskZone add(@RequestBody RiskZone riskZone) {
        return riskZoneRepository.save(riskZone);
    }

    @GetMapping
    public List<RiskZone> getAll() {
        return riskZoneRepository.findAll();
    }
}
