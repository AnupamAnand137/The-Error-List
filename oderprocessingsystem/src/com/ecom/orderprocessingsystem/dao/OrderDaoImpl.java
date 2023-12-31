package com.ecom.orderprocessingsystem.dao;

import com.ecom.orderprocessingsystem.models.Order;
import com.ecom.orderprocessingsystem.helpers.MySQLHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class OrderDaoImpl implements OrderDao {
    private Connection connection;
    private PreparedStatement statement;
    private ResourceBundle resourceBundle;
    private ResultSet resultSet;

    public OrderDaoImpl() {
        super();
        this.resourceBundle = ResourceBundle.getBundle("resources/db");
    }

    @Override
    public Order getOrderById(int orderId) {
        Order order = null;

        try {
            connection = MySQLHelper.getConnection();
            String query = this.resourceBundle.getString("getOrderById");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, orderId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                order = new Order(
                        resultSet.getInt("orderId"),
                        resultSet.getString("orderDate"),
                        resultSet.getInt("customerId"),
                        resultSet.getString("customerShipAddress"),
                        new ArrayList<>(),
                        resultSet.getDouble("orderValue"),
                        resultSet.getDouble("shippingCost"),
                        resultSet.getString("shippingAgency"),
                        resultSet.getString("orderStatus")
                );
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return order;
    }

    @Override
    public List<Order> getPendingQuotesForCustomer(int customerId) {
        List<Order> pendingQuotes = new ArrayList<>();

        try {
            connection = MySQLHelper.getConnection();
            String query = this.resourceBundle.getString("getPendingQuotesForCustomer");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order(
                        resultSet.getInt("orderId"),
                        resultSet.getString("orderDate"),
                        customerId,
                        resultSet.getString("customerShipAddress"),
                        new ArrayList<>(),
                        resultSet.getDouble("orderValue"),
                        resultSet.getDouble("shippingCost"),
                        resultSet.getString("shippingAgency"),
                        resultSet.getString("orderStatus")
                );

                pendingQuotes.add(order);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return pendingQuotes;
    }

    @Override
    public List<Order> getApprovedOrdersForCustomer(int customerId) {
        List<Order> approvedOrders = new ArrayList<>();

        try {
            connection = MySQLHelper.getConnection();
            String query = this.resourceBundle.getString("getApprovedOrdersForCustomer");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order(
                        resultSet.getInt("orderId"),
                        resultSet.getString("orderDate"),
                        customerId,
                        resultSet.getString("customerShipAddress"),
                        new ArrayList<>(),
                        resultSet.getDouble("orderValue"),
                        resultSet.getDouble("shippingCost"),
                        resultSet.getString("shippingAgency"),
                        resultSet.getString("orderStatus")
                );

                approvedOrders.add(order);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return approvedOrders;
    }

    @Override
    public boolean approveQuote(Order order) {
        try {
            connection = MySQLHelper.getConnection();
            String query = this.resourceBundle.getString("approveQuote");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, order.getOrderId());
            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}
