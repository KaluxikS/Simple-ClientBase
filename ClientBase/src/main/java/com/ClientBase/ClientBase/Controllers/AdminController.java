package com.ClientBase.ClientBase.Controllers;

import com.ClientBase.ClientBase.Entities.City;
import com.ClientBase.ClientBase.Entities.Country;
import com.ClientBase.ClientBase.Repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminController {

    @Autowired
    AdminRepository adminRepository;

    @PostMapping("/admin/addCity")
    public String addCity(@RequestBody City city) {
        if (adminRepository.checkIfExists("City", "Name", city.getName())) {
            return "City already exists in the database";
        } else {
            adminRepository.addCity(city);
            return "City added successfully";
        }
    }

    @PostMapping("/admin/addCountry")
    public String addCountry(@RequestBody Country country){
        if (adminRepository.checkIfExists("Country", "Name", country.getName())){
            return "Country already exists in the database";
        } else {
            adminRepository.addCountry(country);
            return "Country added succesfully";
        }
    }

}
