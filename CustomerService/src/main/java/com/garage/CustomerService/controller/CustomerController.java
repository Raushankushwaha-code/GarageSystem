package com.garage.CustomerService.controller;

import com.garage.CustomerService.dto.CustomerDto;
import com.garage.CustomerService.model.Customer;
import com.garage.CustomerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/port")
    public String serverPort( ){
        return customerService.serverPort();
    }

    @PostMapping("/register")
    public ResponseEntity<CustomerDto> customerRegister(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.registerCustomer(customer));
    }
}
