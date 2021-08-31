package com.example.demo.service;

import com.example.demo.dao.ZoneRepo;
import com.example.demo.model.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZoneService {
    @Autowired
    private ZoneRepo zoneRepo;

    public void addZone(String pinCode)
    {
        Zone zone = new Zone(pinCode,0l);
        zoneRepo.save(zone);
    }

    public void updateZone(String pin, Long newCases)
    {
        Zone zone = getZoneData(pin);
        Long cases;
        if(zone != null && zone.getPinCode() != pin)
        {
            cases = zone.getNumCases()+newCases;
        }
        else
        {
            cases = newCases;
        }
        if(cases < 0) cases = 0l;
        Zone newZone = new Zone(pin,cases);
        zoneRepo.save(newZone);
    }

    public Zone getZoneData(String pin)
    {
        return zoneRepo.findById(pin).orElse(null);
    }
}
