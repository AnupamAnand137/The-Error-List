package com.ecom.orderprocessingsystem.dao;

import java.util.List;
import java.util.Map;

import com.ecom.orderprocessingsystem.models.Customer;
import com.ecom.orderprocessingsystem.models.Product;

public interface CustomerDao {
    List<Customer> getAllCustomers();
    Customer getCustomerById(int customerID);
    Map<Product,Integer> getCart(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerID);
}