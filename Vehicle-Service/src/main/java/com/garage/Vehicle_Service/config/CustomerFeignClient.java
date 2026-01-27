package com.garage.Vehicle_Service.config;

import com.garage.Vehicle_Service.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="CUSTOMER-SERVICE")
public interface CustomerFeignClient {

    @GetMapping("/customers/{id}")
    public CustomerDto getCustomerById(@PathVariable Long customerId);
}
