package com.microservices.employeeapp.feignclient;

import com.microservices.addressApp.dto.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(
//        name = "address-service",
//        url = "http://localhost:8081/")

@FeignClient(name = "address-service")
public interface AddressClient {
    @GetMapping("/address/{id}")
    AddressResponse getAddressById(@PathVariable Long id);
}

