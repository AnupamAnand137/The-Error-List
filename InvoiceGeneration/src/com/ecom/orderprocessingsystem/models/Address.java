package com.ecom.orderprocessingsystem.models;

public class Address {
    
    private String buildingName;
    private String streetName;
    private String area;
    private int pincode;
    public Address(String buildingName, String streetName, String area, int pincode) {
        this.buildingName = buildingName;
        this.streetName = streetName;
        this.area = area;
        this.pincode = pincode;
    }
    public Address() {
        super();
    }
    public String getBuildingName() {
        return buildingName;
    }
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
    public String getStreetName() {
        return streetName;
    }
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public int getPincode() {
        return pincode;
    }
    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Address[building name:"+buildingName+", street name:"+streetName+", area:"+area+", pincode:"+pincode+"]";
    }

    

}
