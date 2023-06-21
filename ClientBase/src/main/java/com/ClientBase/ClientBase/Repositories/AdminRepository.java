package com.ClientBase.ClientBase.Repositories;

import com.ClientBase.ClientBase.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addCity(City city) {
        String sql = "INSERT INTO City (CityId, Name, CountryId) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, city.getCityId(), city.getName(), city.getCountryId());
    }

    public List<City> getAllCities() {
        String sql = "SELECT * FROM City";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new City(rs.getInt("CityId"), rs.getString("Name"), rs.getInt("CountryId")));
    }
}
