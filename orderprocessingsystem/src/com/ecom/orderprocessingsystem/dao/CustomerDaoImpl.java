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

import com.ecom.orderprocessingsystem.models.Customer;
import com.ecom.orderprocessingsystem.models.Product;

public class CustomerDaoImpl implements CustomerDao {

	private Connection connection;

	public void CustomerDAOImpl(String jdbcURL, String username, String password) {
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();

		try {
			String query = "SELECT * FROM Customers";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomerID(resultSet.getInt("customerID"));
				customer.setName(resultSet.getString("name"));
				customer.setAddress(resultSet.getString("address"));
				customer.setCity(resultSet.getString("city"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPhoneNo(resultSet.getString("phoneNo"));
				customer.setPincode(resultSet.getString("pincode"));

				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customers;
	}

	@Override
	public Customer getCustomerById(int customerID) {
		Customer customer = null;

		try {
			String query = "SELECT * FROM Customers WHERE customerID = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, customerID);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				customer = new Customer();
				customer.setCustomerID(resultSet.getInt("customerID"));
				customer.setName(resultSet.getString("name"));
				customer.setAddress(resultSet.getString("address"));
				customer.setCity(resultSet.getString("city"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPhoneNo(resultSet.getString("phoneNo"));
				customer.setPincode(resultSet.getString("pincode"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}

	@Override
	public Map<Product, Integer> getCart(Customer customer) {
		Map<Product, Integer> cart = new HashMap<>();

		try {
			String query = "SELECT P.*, CP.quantity FROM Products P "
					+ "JOIN CustomerProducts CP ON P.productID = CP.productID " + "WHERE CP.customerID = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, (int) customer.getCustomerID());
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Product product = new Product();
				(product).setId(resultSet.getInt("productID"));
				product.setName(resultSet.getString("productCategory"));

				int quantity = resultSet.getInt("quantity");

				cart.put(product, quantity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cart;
	}

	@Override
	public void updateCustomer(Customer customer) {
		try {
			String query = "UPDATE Customers SET name = ?, address = ?, city = ?, email = ?, phoneNo = ?, pincode = ? WHERE customerID = ?";
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, customer.getName());
			statement.setString(2, customer.getAddress());
			statement.setString(3, customer.getCity());
			statement.setString(4, customer.getEmail());
			statement.setString(5, customer.getPhoneNo());
			statement.setString(6, customer.getPincode());
			statement.setInt(7, (int) customer.getCustomerID());

			int rowsUpdated = statement.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Customer updated successfully.");
			} else {
				System.out.println("Customer update failed.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer(int customerID) {
	    try {
	        String query = "DELETE FROM Customers WHERE customerID = ?";
	        PreparedStatement statement = connection.prepareStatement(query);
	        
	        statement.setInt(1, customerID);
	        int rowsDeleted = statement.executeUpdate();

	        if (rowsDeleted > 0) {
	            System.out.println("Customer with ID " + customerID + " has been deleted.");
	        } else {
	            System.out.println("No customer found with ID " + customerID + ". No deletion performed.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
