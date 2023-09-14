package com.ecom.orderprocessingsystem.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.ecom.orderprocessingsystem.bl.EmployeeBL;
import com.ecom.orderprocessingsystem.bl.EmployeeBlImpl;
import com.ecom.orderprocessingsystem.dao.CustomerDao;
import com.ecom.orderprocessingsystem.dao.CustomerDaoImpl;
import com.ecom.orderprocessingsystem.models.Address;
import com.ecom.orderprocessingsystem.models.Company;
import com.ecom.orderprocessingsystem.models.Customer;
import com.ecom.orderprocessingsystem.models.Employee;
import com.ecom.orderprocessingsystem.models.Product;

public class testmain {
	    public static void main(String[] args) {

	        // Create a CustomerDao instance
			CustomerDao customerDao = new CustomerDaoImpl();
			
			//employeeBl instance
			EmployeeBL employeeBL = new EmployeeBlImpl();

			//setting comapny details as static as they do not change
			Company company= new Company("ABC associates", new Address("Business Bay", "Airport Road", "Yerwada", 401100), "Pune", 1000000+new Random().nextInt(999999));

			System.out.println(company);

			// Get all customers
			List<Customer> customers = customerDao.getAllCustomers();
			System.out.println("All Customers:");
			for (Customer customer : customers) {
			    System.out.println(customer);
			}

			// Get a customer by ID
			int customerID = 1009; 
			Customer customer = customerDao.getCustomerById(customerID);
			System.out.println("\nCustomer with ID " + customerID + ":");
			System.out.println(customer);

			// Get the cart for a customer
			Map<Product, Integer> cart = customerDao.getCart(customer);
			System.out.println("\nCart for Customer " + customerID + ":");
			for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
			    System.out.println("Product: " + entry.getKey().getName() + ", Quantity: " + entry.getValue());
			
	    }

		// Get all Employees
		Set<Employee> employees;
		try {
			employees = employeeBL.getAllEmployees();
			System.out.println("All Employees:");
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

