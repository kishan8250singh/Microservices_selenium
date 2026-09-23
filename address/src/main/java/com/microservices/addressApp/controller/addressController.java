package com.microservices.addressApp.controller;

import com.microservices.addressApp.dto.AddressResponse;
import com.microservices.addressApp.entity.AddressEntity;
import com.microservices.addressApp.service.AddressService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class addressController {

    private final AddressService addressService;
    public addressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @PostMapping("/save")
    public ResponseEntity<AddressEntity> saveAddress(@RequestBody AddressEntity address) {
        AddressEntity savedAddress = addressService.saveAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAddress);
    }

    @Value("${server.port}")
    private String port;
    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable Long id) {

        // Implement logic to retrieve address by ID
//        AddressResponse address = null;
        System.out.println("Instance"+port);
        AddressResponse addressResponse = addressService.findAddressById(id);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);

    }
}
