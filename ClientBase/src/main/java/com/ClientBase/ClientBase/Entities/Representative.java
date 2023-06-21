package com.ClientBase.ClientBase.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Representative {
    private Integer RepresentativeId;
    private String FirstName;
    private String LastName;
    private Integer DepartmentId;
}
