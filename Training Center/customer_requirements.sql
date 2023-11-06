drop database if exists customer_requirements;

CREATE DATABASE customer_requirements ;

USE customer_requirements ;


CREATE TABLE Customer (
    Cust_ID INT PRIMARY KEY AUTO_INCREMENT,
    customer_Firstname VARCHAR(30),
    customer_LastName VARCHAR(30),
    customer_UserName VARCHAR(30),
    customer_Password VARCHAR(200),
    customer_Email VARCHAR(30),
    customer_PhoneNo VARCHAR(15),
    Customer_Status VARCHAR(20),
    Customer_ActivatedOn DATETIME
);


CREATE TABLE Otp (
    Otp_ID INT PRIMARY KEY AUTO_INCREMENT,
    Customer_UserName varchar(30),
    otpcode VARCHAR(10),
    GeneratedOn DATETIME
);
