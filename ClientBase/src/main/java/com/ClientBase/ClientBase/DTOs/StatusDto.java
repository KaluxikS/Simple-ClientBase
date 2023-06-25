package com.ClientBase.ClientBase.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusDto {
    private String FirstName;
    private String LastName;
    private Date AcquisitionDate;
    private String StatusName;
}
