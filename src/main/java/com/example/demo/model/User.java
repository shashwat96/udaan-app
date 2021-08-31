package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;
    private String name;
    private String dob;
    private int age;
    private String phoneNumber;
    private String pinCode;
    private Boolean isAdmin;
}
