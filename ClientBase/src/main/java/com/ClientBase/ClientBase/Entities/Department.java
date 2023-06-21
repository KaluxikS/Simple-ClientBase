package com.ClientBase.ClientBase.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Integer DepartmentId;
    private String Name;
    private Integer CityId;
}
