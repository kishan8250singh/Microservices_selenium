package com.microservices.addressApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressResponse {
    private String country;
    private String city;
    private String state;
}
