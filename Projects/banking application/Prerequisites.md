# Software Prerequisite:

1. MySQL
2. Eclipse

## Databases Setup:

Step 1: Create Database name bank

Step 2: Create Table name customer

// Create a database 
CREATE DATABASE BANK; 


// Create table
CREATE TABLE `customer` (

 `ac_no` int NOT NULL AUTO_INCREMENT,

 `cname` varchar(45) DEFAULT NULL,

 `balance` varchar(45) DEFAULT NULL,

 `pass_code` int DEFAULT NULL,

 PRIMARY KEY (`ac_no`),

 UNIQUE KEY `cname_UNIQUE` (`cname`)

) ;
## Eclipse Project Setup:

Create New Project
Create A package name banking


## File configuration

Create a Connection class in the banking package

## Step 1: Include JDBC Driver for MySQL

// register jdbc Driver 

String mysqlJDBCDriver = "com.mysql.cj.jdbc.Driver";

Class.forName(mysqlJDBCDriver);

## Step 2: Create Connection Class using MySQL username and password

// Create Connection

String url = "jdbc:mysql://localhost:3306/mydata";

String user = "root";

String pass = "123";

con = DriverManager.getConnection(url, user, pass);
