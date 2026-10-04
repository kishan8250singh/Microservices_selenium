package com.microservices.employeeapp.feignclient;

import com.microservices.employeeapp.dto.AddressResponse;
import org.springframework.stereotype.Component;

@Component
public class AddressClientFallback  implements  AddressClient{
    @Override
    public AddressResponse getAddressById(Long id){
        AddressResponse response = new AddressResponse();
        response.setCity("N/A");
        response.setState("N/A");
        response.setCountry("Address Service Unavailable");
        return response;

    }
}
