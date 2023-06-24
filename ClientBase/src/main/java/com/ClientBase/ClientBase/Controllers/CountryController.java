package com.ClientBase.ClientBase.Controllers;
import com.ClientBase.ClientBase.Entities.Country;
import com.ClientBase.ClientBase.Repositories.AdminRepository;
import com.ClientBase.ClientBase.Repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    CountryRepository countryRepository;


    @PostMapping("/admin/addCountry")
    public String addCountry(@RequestBody Country country){
        if (adminRepository.checkIfExists("Country", "Name", country.getName())){
            return "Country already exists in the database";
        } else {
            countryRepository.addCountry(country);
            return "Country added succesfully";
        }
    }

    @GetMapping("/allCountries")
    public List<Country> getAllCountires(){
        return countryRepository.allCountries();
    }
}
