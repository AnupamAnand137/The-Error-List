package com.ecom.orderprocessingsystem.bl;

import com.ecom.orderprocessingsystem.dao.OrderDAO;
import com.ecom.orderprocessingsystem.model.Order;

import java.util.List;

public class OrderBLImpl implements OrderBL {
    private OrderDAO orderDAO;

    public OrderBLImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public Order getOrderById(int orderId) {
        return orderDAO.getOrderById(orderId);
    }

    @Override
    public List<Order> getPendingQuotesForCustomer(int customerId) {
        return orderDAO.getPendingQuotesForCustomer(customerId);
    }

    @Override
    public List<Order> getApprovedOrdersForCustomer(int customerId) {
        return orderDAO.getApprovedOrdersForCustomer(customerId);
    }

    @Override
    public boolean approveQuote(Order order) {
        return orderDAO.approveQuote(order);
    }
}
