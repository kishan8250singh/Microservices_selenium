package com.microservices.employeeapp.dto;

import com.microservices.addressApp.dto.AddressResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeResponse {
    private String name;
    private String email;
    private boolean isActive = true;
    private AddressResponse addressResponse;
    public EmployeeResponse(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
