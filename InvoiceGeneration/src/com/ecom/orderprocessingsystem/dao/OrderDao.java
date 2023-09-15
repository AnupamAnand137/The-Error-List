package com.ecom.orderprocessingsystem.dao;

import com.ecom.orderprocessingsystem.models.Order;

import java.util.List;

public interface OrderDao {
    Order getOrderById(int orderId);
    List<Order> getPendingQuotesForCustomer(int customerId);
    List<Order> getApprovedOrdersForCustomer(int customerId);
    boolean approveQuote(Order order);
}
