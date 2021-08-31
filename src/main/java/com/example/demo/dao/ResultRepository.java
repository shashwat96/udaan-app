package com.example.demo.dao;

import com.example.demo.model.CovidResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends CrudRepository<CovidResult,String> {
}
