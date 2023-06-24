package com.ClientBase.ClientBase.Repositories;

import com.ClientBase.ClientBase.DTOs.ClientAddDto;
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
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    RepresentativeRepository representativeRepository;



    public List<ClientDto> getAllClients(){
        String sql = "SELECT c.FirstName, c.LastName, c.PESEL, c.Address, ci.Name AS City, r.LastName AS RepresentativeLastName " +
                "FROM Client c " +
                "JOIN City ci ON c.CityId = ci.CityId " +
                "JOIN Representative r ON c.RepresentativeId = r.RepresentativeId " +
                "ORDER BY City DESC";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(ClientDto.class));
    }


    public void addClient(ClientAddDto clientAddDto) {

        boolean cityExists = adminRepository.checkIfExists("City", "Name", clientAddDto.getCity());
        if (!cityExists) {
            throw new IllegalArgumentException("City does not exist in the database");
        }

        int cityId = cityRepository.getCityIdByName(clientAddDto.getCity());

        boolean representativeExists = adminRepository.checkIfExists("Representative", "LastName", clientAddDto.getRepresentativeLastName());
        if (!representativeExists) {
            throw new IllegalArgumentException("Representative does not exist in the database");
        }

        int representativeId = representativeRepository.getRepresentativeIdByLastName(clientAddDto.getRepresentativeLastName());

        String sql = "INSERT INTO Client (FirstName, LastName, PESEL, RepresentativeId, Address, PostalCode, CityId) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, clientAddDto.getFirstName(), clientAddDto.getLastName(), clientAddDto.getPesel(), representativeId, clientAddDto.getAddress(), clientAddDto.getPostalcode(), cityId);
    }



}
