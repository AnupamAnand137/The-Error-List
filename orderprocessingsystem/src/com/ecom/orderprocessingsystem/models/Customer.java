package com.ecom.orderprocessingsystem.models;

import java.util.HashMap;
import java.util.Map;

public class Customer {

	private long customerID;
	private String name;
	private String address;
	private String city;
	private String email;
	private String phoneNo;
	private String pincode;
	// Map of product with the quantity
	private Map<Product, Integer> products;

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public void setProducts(Product product, int count) {
        products.put(product, count);
    }

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", name=" + name + ", address=" + address + ", city=" + city
				+ ", email=" + email + ", phoneNo=" + phoneNo + ", pincode=" + pincode + ", products=" + products + "]";
	}

	public Customer(long customerID, String name, String address, String city, String email, String phoneNo,
			String pincode, Map<Product, Integer> products) {
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

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
