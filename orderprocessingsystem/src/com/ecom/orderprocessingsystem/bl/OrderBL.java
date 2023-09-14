package com.ecom.orderprocessingsystem.bl;

import com.ecom.orderprocessingsystem.model.Order;

import java.util.List;

public interface OrderBL {
    Order getOrderById(int orderId);
    List<Order> getPendingQuotesForCustomer(int customerId);
    List<Order> getApprovedOrdersForCustomer(int customerId);
    boolean approveQuote(Order order);
}
