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
import com.ecom.orderprocessingsystem.models.Customer;
import com.ecom.orderprocessingsystem.models.Product;

public class CustomerDaoImpl implements CustomerDao {

	private Connection connection;
	private PreparedStatement statement;
	private ResourceBundle resourceBundle;
	private ResultSet resultSet;
	
	//read properties
	public CustomerDaoImpl() {
		super();
		this.resourceBundle=ResourceBundle.getBundle("resources/db");
	}
	

	 @Override
	    public Customer getCustomerById(int customerID) {
	        Customer customer = null;

	        try {
	        	connection=MySQLHelper.getConnection();
	    		String query=this.resourceBundle.getString("getCustomerById");
	        	PreparedStatement statement = connection.prepareStatement(query);
	            statement.setInt(1, customerID);
	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()){
		            {
		            	  customer = new Customer(resultSet.getInt("customerID"),
		               		   resultSet.getString("name"),
		                           resultSet.getString("address"),
		                           resultSet.getString("city"),
		                           resultSet.getString("email"),
		                           resultSet.getString("phoneNo"),
		                           resultSet.getInt("pincode"));
		            	
		            }
	            }
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return customer;
	    }

	@Override
	public Map<Product, Integer> getCart(Customer customer) {
		Map<Product, Integer> cart = new HashMap<>();

		try {
			connection=MySQLHelper.getConnection();
    		String query=this.resourceBundle.getString("getCart");
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, (int) customer.getCustomerID());
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Product product = new Product();
				(product).setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("category"));

				int quantity = resultSet.getInt("quantity");

				cart.put(product, quantity);
			}
		} catch (SQLException| ClassNotFoundException e) {
			e.printStackTrace();
		}

		return cart;
	}
	@Override
	public Map<Product, Integer> setCart(Customer customer, Map<Product, Integer> newCart) {
	    Map<Product, Integer> updatedCart = new HashMap<>();

	    try {
	    	connection=MySQLHelper.getConnection();
    		String clearCartQuery=this.resourceBundle.getString("getCart");
	        PreparedStatement clearCartStatement = connection.prepareStatement(clearCartQuery);
	        clearCartStatement.setLong(1, customer.getCustomerID());
	        clearCartStatement.executeUpdate();

	        // Then, insert the products from the new cart
	        String insertProductQuery = this.resourceBundle.getString("insertProductIntoCart");
	        PreparedStatement insertProductStatement = connection.prepareStatement(insertProductQuery);

	        for (Map.Entry<Product, Integer> entry : newCart.entrySet()) {
	            Product product = entry.getKey();
	            int quantity = entry.getValue();

	            insertProductStatement.setLong(1, customer.getCustomerID());
	            insertProductStatement.setLong(2, product.getId());
	            insertProductStatement.setInt(3, quantity);

	            // Execute the insert statement for each product in the new cart
	            insertProductStatement.executeUpdate();

	            // Update the updatedCart map with the new product and quantity
	            updatedCart.put(product, quantity);
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    return updatedCart;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		try {
			connection=MySQLHelper.getConnection();
    		String query=this.resourceBundle.getString("updateCustomer");
			
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, customer.getName());
			statement.setString(2, customer.getAddress());
			statement.setString(3, customer.getCity());
			statement.setString(4, customer.getEmail());
			statement.setLong(5, customer.getPhoneNo());
			statement.setInt(6, customer.getPincode());
			statement.setInt(7, (int) customer.getCustomerID());

			int rowsUpdated = statement.executeUpdate();

			if (rowsUpdated > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerID) {
	    try {
	    	connection=MySQLHelper.getConnection();
    		String query=this.resourceBundle.getString("deleteCustomer");
	        PreparedStatement statement = connection.prepareStatement(query);
	        
	        statement.setInt(1, customerID);
	        int rowsDeleted = statement.executeUpdate();

	        if (rowsDeleted > 0) {
	           return true;
	        } else {
	            return false;
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

}
