package com.ecom.orderprocessingsystem.Bl;

import com.ecom.orderprocessingsystem.models.Order;

import java.util.List;

public interface OrderBl {
    Order getOrderById(int orderId);
    List<Order> getPendingQuotesForCustomer(int customerId);
    List<Order> getApprovedOrdersForCustomer(int customerId);
    boolean approveQuote(Order order);
}

