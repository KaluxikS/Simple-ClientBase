package com.ClientBase.ClientBase.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private String firstName;
    private String lastName;
    private String pesel;
    private String address;
    private String City;
    private String representativeLastName;
}