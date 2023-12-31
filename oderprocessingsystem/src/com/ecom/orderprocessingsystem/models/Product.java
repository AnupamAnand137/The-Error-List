package com.ecom.orderprocessingsystem.models;

public class Product {		

	private int id;
	private String name;
	private double price;
	 private double gst;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String name, double price,double gst) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.gst = gst;
	}
	public int getId() {
		return  id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getGst() {
	  return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", gst=" + gst + ", getName()=" + getName()
				+ ", getPrice()=" + getPrice() + ", getGst()=" + getGst() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	    
}
