package com.garage.Vehicle_Service.entity;

import jakarta.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    @Column(name ="customerId",nullable = false)
    private Long customerId;
    private String vehicleType;

    @Column(nullable = false,unique = true)
    private String registrationNumber;
    private String serviceStatus;
    private String brand;
    private String model;
    private String fuelType;
    private int manufactureYear;
    private int numberOfWheels;

    public Vehicle() {}

    public Vehicle(Long customerId, String vehicleType,String registrationNumber, String status, String brand, String model, String fuelType, int manufactureYear, int numberOfWheels) {
        this.customerId=customerId;
        this.registrationNumber =registrationNumber;
        this.vehicleType = vehicleType;
        this.serviceStatus = status;
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
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

    public String getRegistrationNumber(){
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber){
        this.registrationNumber=registrationNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
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

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
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
