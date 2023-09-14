package com.ecom.orderprocessingsystem.dao;

import java.sql.SQLException;
import java.util.Set;

import com.ecom.orderprocessingsystem.models.Employee;

public interface EmployeeDao {
    
    
    Set<Employee> getAllEmployees() throws SQLException, ClassNotFoundException;
}
