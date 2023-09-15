package com.ecom.orderprocessingsystem.Bl;

import com.ecom.orderprocessingsystem.models.Customer;
import com.ecom.orderprocessingsystem.models.InvoiceGeneration;
import com.ecom.orderprocessingsystem.models.Order;

public interface InvoiceServiceBl {

	public InvoiceGeneration generateInvoice(Order order, Customer customer);
	
	
}
