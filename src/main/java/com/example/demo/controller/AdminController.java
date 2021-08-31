package com.example.demo.controller;

import com.example.demo.model.CovidResult;
import com.example.demo.model.User;
import com.example.demo.service.ResultService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private ResultService resultService;

    @PostMapping("/registerAdmin")
    public ResponseEntity registerUser(@RequestBody User user)
    {
        user.setIsAdmin(true);
        return new ResponseEntity(userService.addUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/updateCovidResult")
    public Object updateCovidResult(@RequestBody CovidResult result)
    {
        return resultService.updateResult(result);
    }
}
