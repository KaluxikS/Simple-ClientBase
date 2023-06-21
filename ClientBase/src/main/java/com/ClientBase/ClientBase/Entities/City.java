package com.ClientBase.ClientBase.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private Integer CityId;
    private String Name;
    private Integer CountryId;
}
