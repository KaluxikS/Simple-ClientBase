package com.ClientBase.ClientBase.Repositories;

import com.ClientBase.ClientBase.DTOs.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<ClientDto> getAll(){
        String sql = "SELECT c.FirstName, c.LastName, c.PESEL, c.Address, ci.Name AS City, r.LastName AS RepresentativeLastName " +
                "FROM Client c " +
                "JOIN City ci ON c.CityId = ci.CityId " +
                "JOIN Representative r ON c.RepresentativeId = r.RepresentativeId " +
                "ORDER BY City DESC";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(ClientDto.class));
    }

}
