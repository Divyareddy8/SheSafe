package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.RiskZone;
import com.example.demo.repository.RiskZoneRepository;

@Service
public class GeoFenceService {

    private final RiskZoneRepository riskZoneRepository;

    public GeoFenceService(RiskZoneRepository riskZoneRepository) {
        this.riskZoneRepository = riskZoneRepository;
    }

    public boolean isInsideRiskZone(double lat, double lng) {
        List<RiskZone> zones = riskZoneRepository.findAll();
        for (RiskZone zone : zones) {
            double distance = haversine(lat, lng, zone.getLatitude(), zone.getLongitude());
            if (distance <= zone.getRadiusMeters()) {
                return true;
            }
        }
        return false;
    }

    // Haversine formula to calculate distance between two coordinates in meters
    private double haversine(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371000; // Earth radius in meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }
}
