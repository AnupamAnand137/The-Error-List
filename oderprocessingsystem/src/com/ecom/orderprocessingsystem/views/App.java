package com.ecom.orderprocessingsystem.views;

import com.ecom.orderprocessingsystem.models.Address;
import com.ecom.orderprocessingsystem.models.Company;
import com.ecom.orderprocessingsystem.models.Customer;
import com.ecom.orderprocessingsystem.models.Employee;
import com.ecom.orderprocessingsystem.models.InvoiceGeneration;
import com.ecom.orderprocessingsystem.models.Invoicedetails;
import com.ecom.orderprocessingsystem.models.Order;
import com.ecom.orderprocessingsystem.models.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.ecom.orderprocessingsystem.Bl.InvoiceServiceBl;
import com.ecom.orderprocessingsystem.Bl.InvoiceServiceBlImpl;
import com.ecom.orderprocessingsystem.dao.CustomerDaoImpl;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 // Create a CustomerDao instance
		CustomerDao customerDao = new CustomerDaoImpl();
		
		//employeeBl instance
		EmployeeBl employeeBL = new EmployeeBlImpl();

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
		  // Create a new order
        Order order = new Order();
        order.setOrderId(1);
        order.setOrderDate("2023-09-11");

        // Add products to the order
        Product product1 = new Product(1011,"Bata Slippers", 100.0, 18.0); // Product id,name, price, GST
        Product product2 = new Product(1012,"Lou Vuitton", 50.0, 12.0);
        order.addProduct(product1);
        order.addProduct(product2);

        // Create a customer
        Customer customer = new Customer(101,"Alia Bhatt", "UP", "lucknow","vsa@gmail.com","8292878289",827004);
        
        Product product3 = new Product(1013,"Gucci", 128.0, 7.0); // Product name, price, GST
        Product product4 = new Product(1014,"Pantanjali", 500.0, 5.0);
        order.addProduct(product3);
        order.addProduct(product4);
        
        // Create an InvoiceService instance
        InvoiceServiceBl invoiceService = new InvoiceServiceBlImpl();

        // Generate the invoice
        InvoiceGeneration invoice = invoiceService.generateInvoice(order, customer);

        // Display the invoice
        System.out.println("Invoice Details:");
        System.out.println("---------------");
        System.out.println("Invoice ID: " + invoice.getInvoiceID());
        System.out.println("Invoice Date: " + invoice.getInvoiceDate());
        System.out.println("Customer Name: " + invoice.getCustomer().getName());
        System.out.println("Customer Address: " + invoice.getCustomer().getAddress());
        System.out.println("Customer City: " + invoice.getCustomer().getCity());
        System.out.println("Products:");
        for (Invoicedetails item : invoice.getLineItems()) {
            System.out.println(item.getProducts().getName() + " - Quantity: " + item.getQuantity() +
                    ", Price: $" + item.getTotalPrice());
        }
        System.out.println("Total GST Amount: $" + invoice.getTotalGST());
        System.out.println("Total Invoice Value: $" + invoice.getTotalInvoiceValue());
        System.out.println("Status: " + invoice.getStatus());
    }
	}



