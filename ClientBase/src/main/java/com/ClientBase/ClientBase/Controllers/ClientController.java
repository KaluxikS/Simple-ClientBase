package com.ClientBase.ClientBase.Controllers;

import com.ClientBase.ClientBase.DTOs.ClientAddDto;
import com.ClientBase.ClientBase.Repositories.ClientRepository;
import com.ClientBase.ClientBase.DTOs.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/addClient")
    public String showAddClientForm(@RequestBody ClientAddDto clientAddDto) {
        clientRepository.addClient(clientAddDto);
        return "Client Added successfully!";
    }
}
