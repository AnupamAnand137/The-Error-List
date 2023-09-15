package com.ecom.orderprocessingsystem.Bl;

import java.util.List;
import java.util.Map;

import com.ecom.orderprocessingsystem.dao.CustomerDao;
import com.ecom.orderprocessingsystem.models.Customer;
import com.ecom.orderprocessingsystem.models.Product;

public class CustomerBlImpl implements CustomerBL {

	private CustomerDao customerDao;

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	@Override
	public Customer getCustomerById(int customerID) {
		if (customerID > 0)
			return customerDao.getCustomerById(customerID);
		else
			return null;
	}

	@Override
	public Map<Product, Integer> getCart(Customer customer) {
		if (customer != null)
			return customerDao.getCart(customer);
		else
			return null;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		boolean status = false;
		if (customer != null)
			status = customerDao.updateCustomer(customer);
		return status;
	}

	@Override
	public boolean deleteCustomer(int customerID) {
		boolean status = false;
		if (customerID > 0)
			status= customerDao.deleteCustomer(customerID);
		return status;

	}

}
