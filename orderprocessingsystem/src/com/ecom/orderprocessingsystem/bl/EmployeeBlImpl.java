package com.ecom.orderprocessingsystem.bl;

import java.sql.SQLException;
import java.util.Set;

import com.ecom.orderprocessingsystem.dao.EmployeeDao;
import com.ecom.orderprocessingsystem.dao.EmployeeDaoImpl;
import com.ecom.orderprocessingsystem.models.Employee;

public class EmployeeBlImpl implements EmployeeBL{

    EmployeeDao employeeDao= new EmployeeDaoImpl();

    @Override
    public Set<Employee> getAllEmployees() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
       return this.employeeDao.getAllEmployees();
    }
    
}
