package com.example.demo.dao;

import com.example.demo.model.UserAssessment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAssessmentRepository extends CrudRepository<UserAssessment,Long> {

}
