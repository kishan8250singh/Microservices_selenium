package com.microservices.employeeapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    private String name;
    private String email;
   // private boolean isActive = true;
    private AddressResponse addressResponse;
}
