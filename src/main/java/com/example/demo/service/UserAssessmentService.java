package com.example.demo.service;

import com.example.demo.dao.UserAssessmentRepository;
import com.example.demo.model.AssessmentResponse;
import com.example.demo.model.UserAssessment;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAssessmentService {
    @Autowired
    private UserAssessmentRepository assessmentRepository;
    @Autowired
    private UserService userService;

    public AssessmentResponse addAssessment(UserAssessment assessment)
    {
        assessmentRepository.save(assessment);
        if(!validateAssessment(assessment))return null;
        return new AssessmentResponse(getRiskFromAssessment(assessment));
    }

    public boolean validateAssessment(UserAssessment assessment)
    {
        return userService.checkUserExists(assessment.getUserId());
    }

    public Double getRiskFromAssessment(@NonNull UserAssessment assessment)
    {
        int numberOfSymptoms = assessment.getSymptoms().split(",").length;
        Long risk = 5l;
        if((assessment.getContactWithCovidPatient() || assessment.getTravelHistory()) && numberOfSymptoms > 0)
        {
            if(numberOfSymptoms > 2)risk = 95l;
            else if(numberOfSymptoms == 2)risk = 75l;
            else risk = 50l;
        }
        return (Double) (risk*1.0);
    }
}
