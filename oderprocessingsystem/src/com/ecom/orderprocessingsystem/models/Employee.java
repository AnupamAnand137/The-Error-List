package com.ecom.orderprocessingsystem.models;

public class Employee {
    
    private long id;
     private String username;
     private String password;

    public Employee(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public Employee() {
        super();
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", username=" + username + "]"; //password is not printed by default
    }

     

}
