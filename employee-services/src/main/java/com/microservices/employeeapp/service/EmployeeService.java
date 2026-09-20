package com.microservices.employeeapp.service;

import com.microservices.addressApp.dto.AddressResponse;
import com.microservices.employeeapp.dto.EmployeeResponse;
import com.microservices.employeeapp.entity.EmployeeEntity;
import com.microservices.employeeapp.repo.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {
    private final ModelMapper modelMapper;
    private final EmployeeRepo employeeRepo;
    private final RestTemplate restTemplate;
    public EmployeeService(ModelMapper modelMapper, EmployeeRepo employeeRepo, RestTemplate restTemplate) {
        this.modelMapper = modelMapper;
        this.employeeRepo = employeeRepo;
        this.restTemplate = restTemplate;
    }
    public EmployeeResponse getEmployeeById(Long id) {
        EmployeeEntity employee = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
//        EmployeeResponse response = new EmployeeResponse();
//        response.setName(employee.getName());
//        response.setEmail(employee.getEmail());
       AddressResponse addressResponse = restTemplate.getForObject("http://localhost:8081/address/{id}", AddressResponse.class, id);
        EmployeeResponse response = modelMapper.map(employee, EmployeeResponse.class);
        response.setAddressResponse(addressResponse);
        return response;
    }
}
