package com.ecom.orderprocessingsystem.Bl;

import com.ecom.orderprocessingsystem.models.Customer;
import com.ecom.orderprocessingsystem.models.InvoiceGeneration;
import com.ecom.orderprocessingsystem.models.Invoicedetails;
import com.ecom.orderprocessingsystem.models.Order;

public class InvoiceServiceBlImpl implements InvoiceServiceBl{

	@Override
	public InvoiceGeneration generateInvoice(Order order, Customer customer) {
		// TODO Auto-generated method stub
		InvoiceGeneration invoice = new InvoiceGeneration();
        invoice.setInvoiceID(order.getOrderId());
        invoice.setInvoiceDate(order.getOrderDate());
        invoice.setCustomer(customer);
        invoice.setLineItems(order.getProductList());

        // Calculate total GST and invoice value
        double totalGST = 0.0;
        double totalInvoiceValue = 0.0;
        for (Invoicedetails item : invoice.getLineItems()) {
            totalGST += item.getTotalGST();
            totalInvoiceValue += item.getTotalPrice();
        }

        invoice.setTotalGST(totalGST);
        invoice.setTotalInvoiceValue(totalInvoiceValue);

        // Set the status
        invoice.setStatus("Paid");

        return invoice;
    }
	}
	


