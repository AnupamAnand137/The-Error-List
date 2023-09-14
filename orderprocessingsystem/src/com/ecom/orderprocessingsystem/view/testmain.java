package com.ecom.orderprocessingsystem.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ecom.orderprocessingsystem.bl.CustomerBL;
import com.ecom.orderprocessingsystem.bl.CustomerBLImpl;
import com.ecom.orderprocessingsystem.models.Customer;
import com.ecom.orderprocessingsystem.models.Product;

public class testmain {
	    public static void main(String[] args) {

	    	CustomerBL customerBL = new CustomerBLImpl();

			// Get all customers
			List<Customer> customers = customerBL.getAllCustomers();
			System.out.println("All Customers:");
			for (Customer customer : customers) {
			    System.out.println(customer);
			}

			// Get a customer by ID
			int customerID = 1009; 
			Customer customer = customerBL.getCustomerById(customerID);
			System.out.println("\nCustomer with ID " + customerID + ":");
			System.out.println(customer);

			// Get the cart for a customer
			Map<Product, Integer> cart = customerBL.getCart(customer);
			System.out.println("\nCart for Customer " + customerID + ":");
			for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
			    System.out.println("Product: " + entry.getKey().getName() + ", Quantity: " + entry.getValue());
			
	    }
	}
}

