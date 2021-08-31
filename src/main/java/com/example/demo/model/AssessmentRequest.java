package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class AssessmentRequest {
    private Long userId;
    private List<String> symptoms;
    private Boolean travelHistory;
    private Boolean contactWithCovidPatient;

    public UserAssessment convert()
    {
        UserAssessment assessment = new UserAssessment();
        assessment.setUserId(userId);
        assessment.setSymptoms(symptoms.toString());
        assessment.setTravelHistory(travelHistory);
        assessment.setContactWithCovidPatient(contactWithCovidPatient);
        return assessment;
    }
}
