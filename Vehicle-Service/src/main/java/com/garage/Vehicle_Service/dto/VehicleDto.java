package com.garage.Vehicle_Service.dto;

import com.garage.Vehicle_Service.entity.Vehicle;

public class VehicleDto {
    private Long vehicleId;
    private Long customerId;
    private String fuelType;
    private String registrationNumber;
    private String serviceStatus;
    private String brand;
    private String model;
    private int manufactureYear;
    private int numberOfWheels;

    public VehicleDto() {}

    public VehicleDto(Long vehicleId, Long customerId, String fuelType, String registrationNumber, String serviceStatus, String brand, String model, int manufactureYear, int numberOfWheels) {
        this.vehicleId =vehicleId;
        this.customerId=customerId;
        this.fuelType = fuelType;
        this.registrationNumber = registrationNumber;
        this.serviceStatus = serviceStatus;
        this.brand = brand;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.numberOfWheels = numberOfWheels;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }
}
