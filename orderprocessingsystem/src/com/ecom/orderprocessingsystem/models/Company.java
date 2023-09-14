package com.ecom.orderprocessingsystem.models;

public class Company {
    
    private String name;
    private Address address;
    private String city;
    private long gstNumber;

    
    public Company() {
        super();
    }


    public Company(String name, Address address, String city, long gstNumber) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.gstNumber = gstNumber;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Address getAddress() {
        return address;
    }


    public void setAddress(Address address) {
        this.address = address;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public long getGstNumber() {
        return gstNumber;
    }


    public void setGstNumber(long gstNumber) {
        this.gstNumber = gstNumber;
    }


    @Override
    public String toString() {
        return "Company [name=" + name + ", address=" + address + ", city=" + city + ", gstNumber=" + gstNumber + "]";
    }

    
}
