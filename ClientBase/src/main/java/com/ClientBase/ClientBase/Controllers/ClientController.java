package com.ClientBase.ClientBase.Controllers;

import com.ClientBase.ClientBase.Entities.City;
import com.ClientBase.ClientBase.Repositories.ClientRepository;
import com.ClientBase.ClientBase.DTOs.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<ClientDto> getAllClients(){
        return clientRepository.getAllClients();
    }

    @GetMapping("/getCities")
    public List<City> getCities() {
        return clientRepository.getAllCities();
    }

    @PostMapping("/addClient") //to make
    public String showAddClientForm(ClientDto clientDto) {
        clientRepository.addClient(clientDto);
        return "add-client-form";
    }
}
