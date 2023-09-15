package com.ecom.orderprocessingsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import com.ecom.orderprocessingsystem.helpers.MySQLHelper;
import com.ecom.orderprocessingsystem.models.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

   private Connection conn;
	private PreparedStatement statement;
	private ResourceBundle resourceBundle;
	private ResultSet resultSet;
	
    public EmployeeDaoImpl()  {
		super();
		// TODO Auto-generated constructor stub
		this.resourceBundle=ResourceBundle.getBundle("db");
		
	}

    @Override
    public Set<Employee> getAllEmployees() throws SQLException, ClassNotFoundException {
     //step 2 get connection
		this.conn=MySQLHelper.getConnection();
		Set<Employee> employees=new HashSet<Employee>();
		
		
		String query=this.resourceBundle.getString("getAllEmployees");
		try{
			//step 3 create statement
			this.statement=this.conn.prepareStatement(query);
			resultSet=this.statement.executeQuery();
			
			//step 4 execute statement and get results
			while(this.resultSet.next()) {
				employees.add(new Employee(this.resultSet.getLong(1),this.resultSet.getString(2), this.resultSet.getString(3)));
			}
		}
		finally {
            //step 5: close the connection
			conn.close();
		}
			
		
		return employees;
    }
    
}
