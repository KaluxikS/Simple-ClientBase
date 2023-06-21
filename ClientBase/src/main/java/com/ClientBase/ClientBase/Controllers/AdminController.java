package com.ClientBase.ClientBase.Controllers;

import com.ClientBase.ClientBase.Entities.City;
import com.ClientBase.ClientBase.Repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminRepository adminRepository;

    @PostMapping("/admin/addCity")
    public String addCity(@RequestBody City city) {
        adminRepository.addCity(city);
        return "City added successfully";
    }

    @GetMapping("/admin/getCities")
    public List<City> getCities() {
        return adminRepository.getAllCities();
    }
}
