package com.ecom.orderprocessingsystem.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ecom.orderprocessingsystem.models.Customer;
import com.ecom.orderprocessingsystem.models.Invoicedetails;


public interface InvoiceServicedao {

	 public  Customer getCustomerDetails(int customerID, Connection connection)
			 throws SQLException;
	 public List<Invoicedetails> getProductItems(int orderID, Connection connection) 
			 throws SQLException;
}
