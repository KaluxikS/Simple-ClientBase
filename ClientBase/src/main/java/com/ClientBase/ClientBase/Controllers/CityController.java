package com.ClientBase.ClientBase.Controllers;

import com.ClientBase.ClientBase.Entities.City;
import com.ClientBase.ClientBase.Repositories.AdminRepository;
import com.ClientBase.ClientBase.Repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    CityRepository cityRepository;

    @PostMapping("/admin/addCity")
    public String addCity(@RequestBody City city) {
        cityRepository.addCity(city);
        return "City added successfully";
    }


    @GetMapping("/getCities")
    public List<City> getCities() {
        return cityRepository.getAllCities();
    }
}
