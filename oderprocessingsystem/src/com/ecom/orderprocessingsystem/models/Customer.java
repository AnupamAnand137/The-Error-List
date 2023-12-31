package com.ecom.orderprocessingsystem.models;

import java.util.HashMap;
import java.util.Map;

public class Customer {

	// Data Members of Customer Class
	// Access specifier - private

	private int customerID;
	private String name;
	private String address;
	private String city;
	private String email;
	private String phoneNo;
	private int pincode;
	// Map of product with the quantity
	// Map for Efficient Navigation & Spatial Analysis
	private Map<Product, Integer> products;

	// Getter & Setter methods

	// not including the setter methods of Customer ID and Name and phone no. as
	// they will be fixed
	// at the time of customer creation and not give the privillage to change these
	// fields after the
	// creation of new customer

	public long getCustomerID() {
		return customerID;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public void setProducts(Product product, int count) {
		products.put(product, count);
	}

	// To string use to print the customer details
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", name=" + name + ", address=" + address + ", city=" + city
				+ ", email=" + email + ", phoneNo=" + phoneNo + ", pincode=" + pincode + "]";
	}

	// Customer's Parameterized Constructor
	public Customer(int customerID, String name, String address, String city, String email, String phoneNo, int pincode) {
		super();
		this.customerID = customerID;
		this.name = name;
		this.address = address;
		this.city = city;
		this.email = email;
		this.phoneNo = phoneNo;
		this.pincode = pincode;
		this.products = new HashMap<>();
	}

	// Customer's Default Constructor
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
