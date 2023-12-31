package com.ecom.orderprocessingsystem.models;

import java.util.ArrayList;

import java.util.Objects;
public class Order {

	
    //private List<Invoicedetails> invoicedetails = new ArrayList<>();

    // Getters and setters
    	 private int orderId;
    	 private String orderDate;
    	 private int customerId;
    	 private  String customerShipAddress;
    	 private ArrayList<Invoicedetails>ProductList=new ArrayList<>();
    	 private double orderValue;
    	 private double shippingCost;
    	 private String shippingAgency;
    	 private String orderStatus;
    	@Override
    	public String toString() {
    		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", customerId=" + customerId
    				+ ", customerShipAddress=" + customerShipAddress + ", ProductList=" + ProductList + ", orderValue="
    				+ orderValue + ", shippingCost=" + shippingCost + ", shippingAgency=" + shippingAgency
    				+ ", orderStatus=" + orderStatus + "]";
    	}
    	@Override
    	public int hashCode() {
    		return Objects.hash(ProductList, customerId, customerShipAddress, orderDate, orderId, orderStatus, orderValue,
    				shippingAgency, shippingCost);
    	}
    	public Order() {
    		super();
    		// TODO Auto-generated constructor stub
    	}
    	public Order(int orderId, String orderDate, int customerId, String customerShipAddress, ArrayList<Invoicedetails> productList,
    			double orderValue, double shippingCost, String shippingAgency, String orderStatus) {
    		super();
    		this.orderId = orderId;
    		this.orderDate = orderDate;
    		this.customerId = customerId;
    		this.customerShipAddress = customerShipAddress;
    		ProductList = productList;
    		this.orderValue = orderValue;
    		this.shippingCost = shippingCost;
    		this.shippingAgency = shippingAgency;
    		this.orderStatus = orderStatus;
    	}
    	@Override
    	public boolean equals(Object obj) {
    		if (this == obj)
    			return true;
    		if (obj == null)
    			return false;
    		if (getClass() != obj.getClass())
    			return false;
    		Order other = (Order) obj;
    		return Objects.equals(ProductList, other.ProductList) && customerId == other.customerId
    				&& Objects.equals(customerShipAddress, other.customerShipAddress)
    				&& Objects.equals(orderDate, other.orderDate) && orderId == other.orderId
    				&& Objects.equals(orderStatus, other.orderStatus)
    				&& Double.doubleToLongBits(orderValue) == Double.doubleToLongBits(other.orderValue)
    				&& Objects.equals(shippingAgency, other.shippingAgency)
    				&& Double.doubleToLongBits(shippingCost) == Double.doubleToLongBits(other.shippingCost);
    	}
    	public int getOrderId() {
    		return orderId;
    	}
    	public void setOrderId(int orderId) {
    		this.orderId = orderId;
    	}
    	public String getOrderDate() {
    		return orderDate;
    	}
    	public void setOrderDate(String orderDate) {
    		this.orderDate = orderDate;
    	}
    	public int getCustomerId() {
    		return customerId;
    	}
    	public void setCustomerId(int customerId) {
    		this.customerId = customerId;
    	}
    	public String getCustomerShipAddress() {
    		return customerShipAddress;
    	}
    	public void setCustomerShipAddress(String customerShipAddress) {
    		this.customerShipAddress = customerShipAddress;
    	}
    	public ArrayList<Invoicedetails> getProductList() {
    		return ProductList;
    	}
    	public void setProductList(ArrayList<Invoicedetails> productList) {
    		ProductList = productList;
    	}
    	public double getOrderValue() {
    		return orderValue;
    	}
    	public void setOrderValue(double orderValue) {
    		this.orderValue = orderValue;
    	}
    	public double getShippingCost() {
    		return shippingCost;
    	}
    	public void setShippingCost(double shippingCost) {
    		this.shippingCost = shippingCost;
    	}
    	public String getShippingAgency() {
    		return shippingAgency;
    	}
    	public void setShippingAgency(String shippingAgency) {
    		this.shippingAgency = shippingAgency;
    	}
    	public String getOrderStatus() {
    		return orderStatus;
    	}
    	public void setOrderStatus(String orderStatus) {
    		this.orderStatus = orderStatus;
    	}
		public void addProduct(Product product) {
			// TODO Auto-generated method stub
			 Invoicedetails item = new Invoicedetails(product);
		        ProductList.add(item);
		}
          
          
    }




