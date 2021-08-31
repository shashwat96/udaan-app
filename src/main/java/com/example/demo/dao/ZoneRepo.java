package com.example.demo.dao;

import com.example.demo.model.Zone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepo extends CrudRepository<Zone,String> {
}
