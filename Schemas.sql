-- order processing system database 
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
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    price DOUBLE,
    category VARCHAR(255)
);

CREATE TABLE CustomerProducts (
    CustomerProductID INT PRIMARY KEY,
    CustomerID INT,
    id INT,
    Quantity INT,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
    FOREIGN KEY (id) REFERENCES Product(id)
);
