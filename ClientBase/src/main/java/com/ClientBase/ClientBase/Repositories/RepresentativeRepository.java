package com.ClientBase.ClientBase.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RepresentativeRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int getRepresentativeIdByLastName(String lastName) {
        String query = "SELECT RepresentativeId FROM Representative WHERE LastName = ?";
        return jdbcTemplate.queryForObject(query, Integer.class, lastName);
    }
}
