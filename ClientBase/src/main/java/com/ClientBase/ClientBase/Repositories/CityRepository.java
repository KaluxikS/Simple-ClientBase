package com.ClientBase.ClientBase.Repositories;
import com.ClientBase.ClientBase.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public int getCityIdByName(String cityName) {
        String query = "SELECT CityId FROM City WHERE Name = ?";
        return jdbcTemplate.queryForObject(query, Integer.class, cityName);
    }

    public void addCity(City city) {
        String sql = "INSERT INTO City (Name, CountryId) VALUES (?, ?)";
        jdbcTemplate.update(sql, city.getName(), city.getCountryId());

    }

    public List<City> getAllCities() {
        String sql = "SELECT * FROM City";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new City(rs.getInt("CityId"), rs.getString("Name"), rs.getInt("CountryId")));
    }
}
