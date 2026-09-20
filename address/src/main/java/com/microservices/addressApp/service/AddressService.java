package com.microservices.addressApp.service;

import com.microservices.addressApp.dto.AddressResponse;
import com.microservices.addressApp.entity.AddressEntity;
import com.microservices.addressApp.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    ModelMapper modelMapper;

    public AddressResponse findAddressById(Long id) {


        // Implement the logic to find the address by employee ID
        // For example, you can call a repository method to fetch the address from the database
        // and return the response object.
       AddressEntity addressEntity = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found"));
        return modelMapper.map(addressEntity, AddressResponse.class); // Replace with actual implementation
    }

    public AddressEntity saveAddress(AddressEntity address) {
        return addressRepository.save(address);
    }
}
