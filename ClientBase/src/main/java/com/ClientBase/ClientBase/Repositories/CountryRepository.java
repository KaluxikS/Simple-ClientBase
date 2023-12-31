package com.ClientBase.ClientBase.Repositories;
import com.ClientBase.ClientBase.Entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AdminRepository adminRepository;


    public void addCountry(Country country){
        String sql = "INSERT INTO Country (Name) VALUES (?)";
        if (adminRepository.checkIfExists("Country", "Name", country.getName())){
            throw new IllegalArgumentException("Country already exists in the database!");
        }
        jdbcTemplate.update(sql, country.getName());
    }

    public List<Country> allCountries(){
        String sql = "SELECT * FROM Country";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Country(rs.getInt("CountryId"), rs.getString("Name")));
    }
}
