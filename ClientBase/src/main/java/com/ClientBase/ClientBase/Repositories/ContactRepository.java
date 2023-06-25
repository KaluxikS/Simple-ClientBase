package com.ClientBase.ClientBase.Repositories;

import com.ClientBase.ClientBase.Entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AdminRepository adminRepository;

    public void addContact(Contact contact){
        String sql = "INSERT INTO Contact(ClientId, TelNum, Email, Fax) VALUES(?, ?, ?, ?)";
        if(!adminRepository.checkIfExists("Client", "ClientId", contact.getClientId().toString())){
            throw new IllegalArgumentException("Client with this ID does not exists!");
        }
        jdbcTemplate.update(sql, contact.getClientId(), contact.getTelNum(), contact.getEmail(), contact.getFax());
    }

    public List<Contact> showContactForClient(int clientId){
        String sql = "SELECT * FROM Contact WHERE ClientID = " + clientId;

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Contact(rs.getInt("ClientId"), rs.getString("TelNum"), rs.getString("Email"), rs.getString("Fax")));
    }

    public void updateContact(Contact contact) {
        String sql = "UPDATE Contact SET TelNum = ?, Email = ?, Fax = ? WHERE ClientId = ?";
        jdbcTemplate.update(sql, contact.getTelNum(), contact.getEmail(), contact.getFax(), contact.getClientId());
    }
}
