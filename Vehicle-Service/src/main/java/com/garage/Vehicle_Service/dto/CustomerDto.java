package com.garage.Vehicle_Service.dto;

public class CustomerDto {

    private Long customerId;
    private String name;
    private String email;
    private String contactNum;

    public CustomerDto() {}

    public CustomerDto(Long customerId, String name, String email, String contactNum) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.contactNum = contactNum;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }
}
