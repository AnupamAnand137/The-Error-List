-- order processing system database 
create database orderprocessingsystem;
use  orderprocessingsystem ;

-- Customer table

CREATE TABLE Customer (
    customerID INT PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    city VARCHAR(255),
    email VARCHAR(255),
    phoneNo BIGINT,
    pincode INT
);

-- Product table
CREATE TABLE Product (
    id INT PRIMARY KEY AUTO_INCREMENT ,
    name VARCHAR(255) not null,
    price DOUBLE not null,
    category VARCHAR(255) not null
);

CREATE TABLE CustomerProducts (
    CustomerProductID INT PRIMARY KEY,
    CustomerID INT,
    id INT,
    Quantity INT,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
    FOREIGN KEY (id) REFERENCES Product(id)
);

-- Employee table
CREATE TABLE Employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) not null,
    password VARCHAR(255) not null
);