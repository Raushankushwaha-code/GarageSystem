package com.garage.Vehicle_Service.config;

import com.garage.Vehicle_Service.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="CUSTOMERSERVICE")
public interface CustomerFeignClient {

    @GetMapping("/customer/{id}")
    public CustomerDto findCustomerByCustomerId(@PathVariable Long id);

    @GetMapping("/customer/port")
    public String getCustomerPort();
}
