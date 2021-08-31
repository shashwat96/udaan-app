package com.example.demo.controller;

import com.example.demo.model.AssessmentRequest;
import com.example.demo.model.AssessmentResponse;
import com.example.demo.model.User;
import com.example.demo.model.UserAssessment;
import com.example.demo.service.UserAssessmentService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserAssessmentService assessmentService;

    @PostMapping("/registerUser")
    public ResponseEntity registerUser(@RequestBody User user)
    {
        return new ResponseEntity(userService.addUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/selfAssessment")
    public ResponseEntity selfAssessment(@RequestBody AssessmentRequest assessmentRequest)
    {
        UserAssessment assessment = assessmentRequest.convert();
        AssessmentResponse response = assessmentService.addAssessment(assessment);
        if(response != null)
            return new ResponseEntity(response, HttpStatus.CREATED);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
