package com.ClientBase.ClientBase.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type {
    private Integer TypeId;
    private Integer PhoneNumber;
    private String Email;
    private Integer fax;
}
