package com.example.demo.controller;

import com.example.demo.model.Zone;
import com.example.demo.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class ZoneController {
    @Autowired
    private ZoneService zoneService;

    @PostMapping("/getZoneInfo")
    public ResponseEntity getZoneInfo(@RequestBody Zone reqZone)
    {
        Zone zone = zoneService.getZoneData(reqZone.getPinCode());
        return new ResponseEntity(zone, HttpStatus.OK);
    }
}
