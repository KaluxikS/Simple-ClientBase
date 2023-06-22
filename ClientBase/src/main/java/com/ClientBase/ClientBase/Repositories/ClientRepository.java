package com.ClientBase.ClientBase.Repositories;

import com.ClientBase.ClientBase.DTOs.ClientDto;
import com.ClientBase.ClientBase.Entities.City;
import com.ClientBase.ClientBase.Entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    AdminRepository adminRepository;

    

    public List<ClientDto> getAllClients(){
        String sql = "SELECT c.FirstName, c.LastName, c.PESEL, c.Address, ci.Name AS City, r.LastName AS RepresentativeLastName " +
                "FROM Client c " +
                "JOIN City ci ON c.CityId = ci.CityId " +
                "JOIN Representative r ON c.RepresentativeId = r.RepresentativeId " +
                "ORDER BY City DESC";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(ClientDto.class));
    }

    public List<City> getAllCities() {
        String sql = "SELECT * FROM City";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new City(rs.getInt("CityId"), rs.getString("Name"), rs.getInt("CountryId")));
    }

    public void addClient(ClientDto clientDto) {

        boolean cityExists = adminRepository.checkIfExists("City", "Name", clientDto.getCity());
        if (!cityExists) {
            throw new IllegalArgumentException("City does not exist in the database");
        }

        int cityId = adminRepository.getCityIdByName(clientDto.getCity());

        boolean representativeExists = adminRepository.checkIfExists("Representative", "LastName", clientDto.getRepresentativeLastName());
        if (!representativeExists) {
            throw new IllegalArgumentException("Representative does not exist in the database");
        }

        int representativeId = adminRepository.getRepresentativeIdByLastName(clientDto.getRepresentativeLastName());

        String sql = "INSERT INTO Client (FirstName, LastName, PESEL, Address, CityId, RepresentativeId) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, clientDto.getFirstName(), clientDto.getLastName(), clientDto.getPesel(), clientDto.getAddress(), cityId, representativeId);
    }



}
