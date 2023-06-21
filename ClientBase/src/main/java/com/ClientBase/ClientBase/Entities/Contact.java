package com.ClientBase.ClientBase.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private Timestamp Date;
    private Integer CustomerId;
    private String Description;
    private Integer TypeId;

}
