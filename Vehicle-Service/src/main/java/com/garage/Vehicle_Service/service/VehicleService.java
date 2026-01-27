package com.garage.Vehicle_Service.service;

import com.garage.Vehicle_Service.config.CustomerFeignClient;
import com.garage.Vehicle_Service.dto.CustomerDto;
import com.garage.Vehicle_Service.dto.VehicleDto;
import com.garage.Vehicle_Service.entity.Vehicle;
import com.garage.Vehicle_Service.repo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<VehicleDto> vehicleRegistration(Map<Long,Vehicle> vehicles){

        List<VehicleDto> vehicleDTos=new ArrayList<>();

        for (Map.Entry<Long,Vehicle> vehicleEntry: vehicles.entrySet()){
            Vehicle vehicle =vehicleEntry.getValue();
            VehicleDto vehicleDto=new VehicleDto();

            if (vehicle != null){
                vehicleRepo.save(vehicle);
                vehicleDto.setCustomerId(vehicle.getVehicleId());
                vehicleDto.setBrand(vehicle.getBrand());
                vehicleDto.setFuelType(vehicle.getFuelType());
                vehicleDto.setManufactureYear(vehicle.getManufactureYear());
                vehicleDto.setModel(vehicle.getModel());
                vehicleDto.setRegistrationNumber(vehicle.getRegistrationNumber());
                vehicleDto.setVehicleId(vehicle.getVehicleId());
                vehicleDto.setServiceStatus(vehicle.getServiceStatus());
                vehicleDto.setNumberOfWheels(vehicleDto.getNumberOfWheels());
                vehicleDTos.add(vehicleDto);
            }
        }

        return vehicleDTos;
    }


}
