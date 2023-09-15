package com.ecom.orderprocessingsystem.Bl;

import java.util.List;
import java.util.Map;

import com.ecom.orderprocessingsystem.models.Customer;
import com.ecom.orderprocessingsystem.models.Product;

public interface CustomerBL {
	
	
	//Validation of CRUD Operations on Customer Entity follows following methods:
	
	//Create not implemented as the data is pre-populated in the Data
	
	//Validation of Get the Data of all the Customers method
    List<Customer> getAllCustomers();
    
    //Validation of Get the Customer data by their ID method
    Customer getCustomerById(int customerID);
    
    //Validation of get the details of the cart specific to customer method
    // product with its Quantity 
    Map<Product,Integer> getCart(Customer customer);
    
    // Validation of Update Customer Data method
    boolean updateCustomer(Customer customer);
    
    //Validation of Delete Customer Data using customer ID method
    boolean deleteCustomer(int customerID);

}
