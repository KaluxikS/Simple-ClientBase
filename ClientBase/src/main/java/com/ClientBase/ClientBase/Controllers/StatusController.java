package com.ClientBase.ClientBase.Controllers;

import com.ClientBase.ClientBase.DTOs.StatusDto;
import com.ClientBase.ClientBase.Repositories.ClientStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatusController {

    @Autowired
    ClientStatusRepository clientStatusRepository;

    @GetMapping("/status/{ifactive}")
    public List<StatusDto> getClientsByStatus(@PathVariable String ifactive){
        return clientStatusRepository.getClientsByStatus(ifactive);
    }


}
