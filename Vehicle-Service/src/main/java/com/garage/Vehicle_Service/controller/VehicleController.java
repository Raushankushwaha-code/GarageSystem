package com.garage.Vehicle_Service.controller;

import com.garage.Vehicle_Service.dto.VehicleDto;
import com.garage.Vehicle_Service.entity.Vehicle;
import com.garage.Vehicle_Service.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/vehicleRegistry")
    public ResponseEntity<List<VehicleDto>> vehicleRegistry(@RequestBody Map<Long, Vehicle> vehicles)
    {
        return ResponseEntity.ok(vehicleService.vehicleRegistration(vehicles)) ;
    }
}
