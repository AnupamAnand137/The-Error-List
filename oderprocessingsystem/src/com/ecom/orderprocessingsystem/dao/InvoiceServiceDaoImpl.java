package com.ecom.orderprocessingsystem.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.ecom.orderprocessingsystem.helpers.MySQLHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecom.orderprocessingsystem.models.Customer;
import com.ecom.orderprocessingsystem.models.Invoicedetails;
import com.ecom.orderprocessingsystem.models.Product;

public class InvoiceServiceDaoImpl implements InvoiceServicedao {
	private Connection connection;
	private PreparedStatement statement;
	private ResourceBundle resourceBundle;
	private ResultSet resultSet;
	
	//read properties
	public InvoiceServiceDaoImpl() {
		super();
		this.resourceBundle=ResourceBundle.getBundle("resources/db");
	}
		

	@Override
	public Customer getCustomerDetails(int customerID, Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		 
		Customer customer = null;
        String sql = "SELECT * FROM customers WHERE customer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, customerID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
               customer = new Customer(resultSet.getInt("customerID"),
            		   resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNo"),
                        resultSet.getInt("pincode"));
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return customer;
	}

	@Override
	public List<Invoicedetails> getProductItems(int orderID, Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		 List<Invoicedetails> lineItems = new ArrayList<>();
	        String sql = "SELECT p.*, oi.quantity FROM products p, order_items oi " +
	                     "WHERE oi.product_id = p.product_id AND oi.order_id = ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, orderID);
	            ResultSet resultSet = statement.executeQuery();
	            while (resultSet.next()) {
	                Product product = new Product(resultSet.getInt(1),
	                        resultSet.getString("name"),
	                        resultSet.getDouble("price"),
	                        resultSet.getDouble("gst"));
	                int quantity = resultSet.getInt("quantity");
	                Invoicedetails lineItem = new Invoicedetails(product, quantity);
	                lineItems.add(lineItem);
	            }
	        } catch (SQLException e) {
	            handleSQLException(e);
	        }
	        return lineItems;
	}

	 private void handleSQLException(SQLException e) {
	        // You can customize the error handling here, e.g., log the error, throw a custom exception, etc.
	        System.err.println("Database Error: " + e.getMessage());
	        e.printStackTrace();
	    }
	

}
