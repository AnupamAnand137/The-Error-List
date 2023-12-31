package com.ecom.orderprocessingsystem.dao;

import java.util.List;
import java.util.Map;

import com.ecom.orderprocessingsystem.models.Customer;
import com.ecom.orderprocessingsystem.models.Product;

public interface CustomerDao {
	
	//CRUD Operations on Customer Entity follows following methods:
	
	
	
    
    //Get the Customer data by their ID
    Customer getCustomerById(int customerID);
    
    //get the details of the cart specific to customer 
    // product with its Quantity 
    Map<Product,Integer> getCart(Customer customer);
    
    Map<Product, Integer> setCart(Customer customer, Map<Product, Integer> newCart); 
    
    // Update Customer Data 
    boolean updateCustomer(Customer customer);
    
    //Delete Customer Data using customer ID 
    boolean deleteCustomer(int customerID);
    
}