package com.garage.CustomerService.service;

import com.garage.CustomerService.dto.CustomerDto;
import com.garage.CustomerService.model.Customer;
import com.garage.CustomerService.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private Environment env;

    public String serverPort( ){
        String port=env.getProperty("server.port");
        return "Hii from customer Service "+port;
    }

    public CustomerDto registerCustomer(Customer customer){
        if (customer == null){
            throw new RuntimeException("Customer Not found");
        } else {
            customerRepo.save(customer);
        }

        return new CustomerDto(
                customer.getCustomerId(),
                customer.getCustomerName(),
                customer.getContactNum(),
                customer.getEmail(),
                customer.getVehicleId());
    }
}
