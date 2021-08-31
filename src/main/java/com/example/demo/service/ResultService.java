package com.example.demo.service;

import com.example.demo.dao.ResultRepository;
import com.example.demo.model.CovidResult;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private ZoneService zoneService;
    @Autowired
    private UserService userService;

    public Map<String,String> updateResult(CovidResult result)
    {
        Map<String,String> hm = new HashMap<>();
        CovidResult previousResult = resultRepository.findById(result.getUserId()).orElse(null);
        Boolean resultChange;
        if(previousResult != null && previousResult.getResult().equals(result.getResult()))resultChange = false;
        else resultChange = true;
        Long userId = Long.parseLong(result.getUserId()),newCase;
        User user;
        if(userService.checkUserExists(userId))user = userService.getUserByUserId(userId);
        else user = new User();
        if(user.getUserId() != 0L && resultChange)
        {
            if(result.getResult().equals("positive"))newCase = 1L;
            else newCase = -1L;
            zoneService.updateZone(user.getPinCode(),newCase);
        }
        resultRepository.save(result);
        hm.put("updated","true");
        return hm;
    }
}
