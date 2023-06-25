package com.ClientBase.ClientBase.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private Integer ClientId;
    private String TelNum;
    private String Email;
    private String Fax;
}
