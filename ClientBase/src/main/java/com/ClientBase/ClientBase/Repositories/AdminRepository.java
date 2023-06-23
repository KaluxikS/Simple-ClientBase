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

    public int getCityIdByName(String cityName) {
        String query = "SELECT CityId FROM City WHERE Name = ?";
        return jdbcTemplate.queryForObject(query, Integer.class, cityName);
    }

    public int getRepresentativeIdByLastName(String lastName) {
        String query = "SELECT RepresentativeId FROM Representative WHERE LastName = ?";
        return jdbcTemplate.queryForObject(query, Integer.class, lastName);
    }

    public void addCity(City city) {
        String sql = "INSERT INTO City (Name, CountryId) VALUES (?, ?)";
        jdbcTemplate.update(sql, city.getName(), city.getCountryId());

    }

    public void addCountry(Country country){
        String sql = "INSERT INTO Country (Name) VALUES (?)";
        jdbcTemplate.update(sql, country.getName());
    }
}
