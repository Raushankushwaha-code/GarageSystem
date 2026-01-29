package com.garage.Vehicle_Service.service;

import com.garage.Vehicle_Service.config.CustomerFeignClient;
import com.garage.Vehicle_Service.dto.CustomerDto;
import com.garage.Vehicle_Service.dto.VehicleDto;
import com.garage.Vehicle_Service.entity.Vehicle;
import com.garage.Vehicle_Service.repo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private CustomerFeignClient customerFeignClient;

    @Autowired
    private Environment env;

    public String customerPort( ){

        return customerFeignClient.getCustomerPort();
    }

    //Register the vehicle and return vehicleDto
    public List<VehicleDto> vehicleRegistration(List<Vehicle> vehicles){

        List<VehicleDto> vehicleDTos=new ArrayList<>();

        for (Vehicle vehicle: vehicles){
            VehicleDto vehicleDto=new VehicleDto();

            if (vehicle == null){
                throw new RuntimeException("Vehicle Not find");

            } else {
                vehicleRepo.save(vehicle);
                vehicleDto.setVehicleId(vehicle.getVehicleId());
                vehicleDto.setCustomerId(vehicle.getCustomerId());
                vehicleDto.setBrand(vehicle.getBrand());
                vehicleDto.setFuelType(vehicle.getFuelType());
                vehicleDto.setManufactureYear(vehicle.getManufactureYear());
                vehicleDto.setModel(vehicle.getModel());
                vehicleDto.setRegistrationNumber(vehicle.getRegistrationNumber());
                vehicleDto.setServiceStatus(vehicle.getServiceStatus());
                vehicleDto.setNumberOfWheels(vehicle.getNumberOfWheels());
                vehicleDTos.add(vehicleDto);
            }
        }

        return vehicleDTos;

    }

    //Find vehicle by customerId and return list vehicleDto
    public List<VehicleDto> findVehicleByCustomerId(Long cusId){
        List<Vehicle> vehicles=vehicleRepo.findByCustomerId(cusId);
        if (vehicles == null){
            throw new RuntimeException("Vehicle not exist with this customerId");
        }

        List<VehicleDto> vehicleDTos=new ArrayList<>();

        for (Vehicle vehicle: vehicles) {
            VehicleDto vehicleDto = new VehicleDto();

            vehicleDto.setVehicleId(vehicle.getVehicleId());
            vehicleDto.setCustomerId(vehicle.getCustomerId());
            vehicleDto.setBrand(vehicle.getBrand());
            vehicleDto.setFuelType(vehicle.getFuelType());
            vehicleDto.setManufactureYear(vehicle.getManufactureYear());
            vehicleDto.setModel(vehicle.getModel());
            vehicleDto.setRegistrationNumber(vehicle.getRegistrationNumber());
            vehicleDto.setServiceStatus(vehicle.getServiceStatus());
            vehicleDto.setNumberOfWheels(vehicle.getNumberOfWheels());
            vehicleDTos.add(vehicleDto);
        }

        return vehicleDTos;
    }
}
