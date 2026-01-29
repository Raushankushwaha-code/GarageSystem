package com.garage.Vehicle_Service.controller;

import com.garage.Vehicle_Service.config.CustomerFeignClient;
import com.garage.Vehicle_Service.dto.VehicleDto;
import com.garage.Vehicle_Service.entity.Vehicle;
import com.garage.Vehicle_Service.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private CustomerFeignClient customerFeignClient;

    @GetMapping("/port")
    public String findPort( ){

        return vehicleService.customerPort();
    }

    @PostMapping("/register")
    public ResponseEntity<List<VehicleDto>> vehicleRegistry(@RequestBody List<Vehicle> vehicles)
    {

        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.vehicleRegistration(vehicles));
    }

    @GetMapping("/findVehicle/{customerId}")
    public ResponseEntity<List<VehicleDto>> findVehicleByCustomerId(@PathVariable Long customerId){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findVehicleByCustomerId(customerId));
    }
}
