package com.ClientBase.ClientBase.Repositories;

import com.ClientBase.ClientBase.DTOs.StatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientStatusRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<StatusDto> getClientsByStatus(String active){
        active = active.toLowerCase();
        if (active.equals("active") || active.equals("inactive")){
            String sql = "SELECT c.FirstName, c.LastName, cs.AcquisitionDate, s.StatusName FROM ClientStatus cs " +
                    "JOIN Client c ON c.ClientId = cs.ClientId " +
                    "JOIN Status s ON s.StatusId = cs.StatusId " +
                    "WHERE s.StatusName = " + "\"" + active + "\"";
            return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(StatusDto.class));
        }
        else{
            throw new IllegalArgumentException("Status can be active or inactive !");
        }
    }
}
