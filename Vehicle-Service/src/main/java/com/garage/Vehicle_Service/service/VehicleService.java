package com.garage.Vehicle_Service.service;

import com.garage.Vehicle_Service.config.CustomerFeignClient;
import com.garage.Vehicle_Service.config.GlobalExceptionHandler;
import com.garage.Vehicle_Service.dto.CustomerDto;
import com.garage.Vehicle_Service.dto.VehicleDto;
import com.garage.Vehicle_Service.entity.Vehicle;
import com.garage.Vehicle_Service.repo.VehicleRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private CustomerFeignClient customerFeignClient;

    @Autowired
    private Environment env;

    @Autowired
    private GlobalExceptionHandler globalExceptionHandler;

    //Register the vehicle and return vehicleDto
    public List<VehicleDto> vehicleRegistration(List<Vehicle> vehicles){

        List<VehicleDto> vehicleDTos=new ArrayList<>();

        for (Vehicle vehicle: vehicles){

            CustomerDto customerDto=customerFeignClient.findCustomerByCustomerId(vehicle.getCustomerId());

            if (customerDto == null){
                throw new RuntimeException("Customer not foud with this customerID"+vehicle.getCustomerId());
            }

            if (vehicle == null){
                throw new RuntimeException("Vehicle Not find");

            }

            else {
                vehicleRepo.save(vehicle);
                VehicleDto vehicleDto=vehicleConvertIntoVehicleDto(vehicle);
                vehicleDTos.add(vehicleDto);
            }
        }

        return vehicleDTos;

    }

    //Find vehicle by customerId and return list vehicleDto
    public List<VehicleDto> findVehicleByCustomerId(Long cusId) {
        List<Vehicle> vehicles = vehicleRepo.findByCustomerId(cusId);
        if (vehicles == null) {
            throw new RuntimeException("Vehicle not exist with this customerId");
        }

        List<VehicleDto> vehicleDTos = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            VehicleDto vehicleDto = vehicleConvertIntoVehicleDto(vehicle);
            vehicleDTos.add(vehicleDto);
        }

        return vehicleDTos;
    }

    //vehicle find by vehicleId
    public VehicleDto findVehicleByVehicleId(Long vehId){
        Vehicle vehicle=vehicleRepo.findById(vehId)
                .orElseThrow(()->new RuntimeException("Vehicle not Exist with this vehicleId"));
        return vehicleConvertIntoVehicleDto(vehicle);
    }

//Find all vehicles and return VehicleDto List
    public List<VehicleDto> findAllVehicle( ){
        List<VehicleDto> vehicleDTos= new ArrayList<>();

        List<Vehicle> vehicleList=vehicleRepo.findAll();
        for (Vehicle vehicle:vehicleList){
            VehicleDto vehicleDto=vehicleConvertIntoVehicleDto(vehicle);
            vehicleDTos.add(vehicleDto);
        }

        return vehicleDTos;
    }

    public VehicleDto vehicleConvertIntoVehicleDto(Vehicle vehicle ){
        return new VehicleDto(
                vehicle.getVehicleId()
                ,vehicle.getCustomerId()
                ,vehicle.getFuelType()
                ,vehicle.getRegistrationNumber()
                ,vehicle.getServiceStatus()
                ,vehicle.getBrand()
                ,vehicle.getModel()
                ,vehicle.getManufactureYear()
                ,vehicle.getNumberOfWheels());
    }
}
