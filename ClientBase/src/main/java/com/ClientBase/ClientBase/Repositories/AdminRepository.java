package com.ClientBase.ClientBase.Repositories;
import com.ClientBase.ClientBase.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class AdminRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean checkIfExists(String tableName, String columnName, String value) {
        String checkIfExistsQuery = "SELECT COUNT(*) FROM " + tableName + " WHERE " + columnName + " = ?";
        int count = jdbcTemplate.queryForObject(checkIfExistsQuery, Integer.class, value);
        return count > 0;
    }
}
