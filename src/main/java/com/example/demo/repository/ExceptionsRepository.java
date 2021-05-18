package com.example.demo.repository;

import com.example.demo.model.Exceptions;
import com.example.demo.querys.Querys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ExceptionsRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public void addException(Exceptions exception){
        jdbcTemplate.update(Querys.ADD_EXCEPTIONS, exception.getDate(), exception.getMessage());

    }
}
