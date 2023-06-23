package com.ClientBase.ClientBase.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientAddDto {
    private String firstName;
    private String lastName;
    private String pesel;
    private String address;
    private String postalcode;
    private String city;
    private String representativeLastName;
}