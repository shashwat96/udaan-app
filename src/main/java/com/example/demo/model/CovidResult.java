package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "result")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CovidResult {
    @Id
    private String userId;
    private String adminId;
    private String result;
}
