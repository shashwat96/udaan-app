package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "assessment")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAssessment {
    @Id
    private Long userId;
    private String symptoms;
    private Boolean travelHistory;
    private Boolean contactWithCovidPatient;
}
