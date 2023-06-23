package com.ClientBase.ClientBase.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Client {
    private Integer ClientId;
    private String FirstName;
    private String LastName;
    private String Pesel;
    private Integer RepresentativeId;
    private String Address;
    private String PostalCode;
    private Integer CityId;
}
