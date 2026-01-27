package com.iacademy.hrb05.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeFilter extends Filter {

    private String key;
    private String email;
    private Double minSalary;
    private Double maxSalary;


}
