package com.ecom.orderprocessingsystem.Bl;

import java.sql.SQLException;
import java.util.Set;

import com.ecom.orderprocessingsystem.models.Employee;

public interface EmployeeBl {
    Set<Employee> getAllEmployees() throws SQLException, ClassNotFoundException;
}