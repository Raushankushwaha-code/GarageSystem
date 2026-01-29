package com.garage.CustomerService.dto;

public class CustomerDto {

    private Long customerId;
    private String customerName;
    private String contactNum;
    private String email;
    private Long vehicleId;

    public CustomerDto() {
    }

    public CustomerDto(Long customerId, String customerName, String contactNum, String email, Long vehicleId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contactNum = contactNum;
        this.email = email;
        this.vehicleId = vehicleId;
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
}
