package com.garage.CustomerService.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String customerName;
    private String contactNum;
    private String email;
    private Long vehicleId;

    public Customer() { }

    public Customer(Long customerId, String customerName, String contactNum, String email, Long vehicleId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contactNum = contactNum;
        this.email = email;
        this.vehicleId = vehicleId;
    }

    public Customer(String customerName, String contactNum, String email, Long vehicleId) {
        this.customerName = customerName;
        this.contactNum = contactNum;
        this.email = email;
        this.vehicleId = vehicleId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
