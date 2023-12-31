package com.ecom.orderprocessingsystem.Bl;

import com.ecom.orderprocessingsystem.dao.OrderDao;
import com.ecom.orderprocessingsystem.models.Order;

import java.util.List;

public class OrderBlImpl implements OrderBl {
    private OrderDao orderDAO;

    public OrderBlImpl(OrderDao orderDAO) {
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

