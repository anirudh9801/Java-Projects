drop database if exists insurance;

 

 

create database insurance;

 

 

use insurance;

 

 

drop table if exists insurance_details;

 

 

create table insurance_details(
insuranceId varchar(5) primary key,
insuranceName varchar (50),
insuranceType varchar (50),
premiumStart varchar (10),
premiumEnd varchar(10),
minPeriod varchar(10),
maxPeriod varchar (10),
launchDate date,
status varchar (10)
);

 

 

Insert into insurance_details (insuranceId,insuranceName,insuranceType,
premiumStart,premiumEnd,minPeriod,maxPeriod,launchDate,status)
values
('INS01', 'The Aam Aadmi Bima Yojana', 'Health Insurance', '5 k', '200 k', '5 years', '10 years', '2023-01-15', 'Active'),
('INS02', 'The Pradhan Mantri Suraksha Bima Yojana ', 'Health Insurance', '3 k', '150 k', '3 years', '30 years', '2023-02-15', 'Active'),
('INS03', 'The Mahatma Jyotiba Phule Jan Arogya Yojana ', 'Health Insurance', '3 k', '500 k', '2 years', '25 years', '2023-03-15', 'Active'),
('INS04', 'The Bhamashah Swasthya Bima Yojana ', 'Health Insurance', '10 k', '65 k', '3 years', '45 years', '2023-04-15', 'Active'),
('INS05', 'Bajaj Allianz Car Insurance ', 'Motor Insurance', '15 k', '125 k', '2 years', '15 years', '2023-05-17', 'Active'),
('INS06', 'ICICI Lombard Car Insurance ', 'Motor Insurance', '10 k', '100 k', '3 years', '8 years', '2023-06-18', 'Active'),
('INS07', 'National Car Insurance', 'Motor Insurance', '7 k', '80 k', '2 years', '10 years', '2023-07-19', 'Active'),
('INS08', 'Bharti AXA Home Insurance', 'Home Insurance','15 k', '2 Cr', '5 years', '20 years', '2023-07-20', 'Active'),
('INS09', 'Shriram General Home Insurance', 'Home Insurance', '20 k', '5 Cr', '2 years', '40 years', '2023-07-21', 'Active'),
('INS10', 'Royal Sundaram Home Insurance', 'Home Insurance', '12.5 k' , '7 Cr', '3 years', '38 years', '2023-07-22', 'Active'),
('INS11', 'Bharat Griha Raksha', 'Fire Insurance', '5 Cr' , '40 Cr', '1 years', '30 years', '2023-07-21', 'Active'),
('INS12', 'Bharat Sookshma Udyam Surakhsa', 'Fire Insurance', '900 k' , '5 Cr', '4 years', '20 years', '2023-08-22', 'Active'),
('INS13', 'Bharat Laghu Udyam Suraksha', 'Fire Insurance', '900 k' , '5 Cr', '4 years', '20 years', '2023-08-22', 'Active');
select * from insurance_details;

 

 

drop table if exists customer_details;

 

 

create table customer_details(
custId INT AUTO_INCREMENT Not null,
firstName varchar (50),
lastName varchar (50),
gender varchar (10),
dob date,
username varchar (50),
password varchar (50),
status varchar (10),
PRIMARY KEY (custId)
);

 

INSERT INTO customer_details (firstName, lastName, gender, dob, username, password, status)
VALUES
    ('John', 'Doe', 'Male', '1990-01-15', 'johndoe123', 'password123', 'Active'),
    ('Jane', 'Smith', 'Female', '1985-05-20', 'janesmith456', 'securepass', 'Inactive');

 

select * from customer_details;
ALTER TABLE customer_details
ADD email varchar(100);
CREATE TABLE authentication (
    authId INT AUTO_INCREMENT,
    custId INT,
    username VARCHAR(255),
    Passcode VARCHAR(255),
    otp VARCHAR(255),
    status VARCHAR(50),
    PRIMARY KEY (authId)
);
use insurance;
CREATE TABLE insurance_plans (
    PlanId INT NOT NULL AUTO_INCREMENT,
    insuranceId VARCHAR(255) NOT NULL,
    PremiumAmount VARCHAR(255) NOT NULL,
    CoverageAmount VARCHAR(255) NOT NULL,
    PRIMARY KEY (PlanId)
);
INSERT INTO insurance_plans (InsuranceId, PremiumAmount, CoverageAmount)
VALUES
    ('INS01', '50000', '800000'),
    ('INS01', '55000', '750000'),
    ('INS01', '60000', '700000'),
    ('INS01', '52000', '900000'),
    ('INS01', '48000', '650000');
INSERT INTO insurance_plans (InsuranceId, PremiumAmount, CoverageAmount)
VALUES
     ('INS02', '51000', '820000'),
    ('INS02', '59000', '780000'),
    ('INS02', '56000', '710000'),
    ('INS02', '53000', '950000'),
    ('INS02', '58000', '670000');
   INSERT INTO insurance_plans (InsuranceId, PremiumAmount, CoverageAmount)
VALUES 
      ('INS03', '54000', '860000'),
    ('INS03', '62000', '920000'),
    ('INS03', '57000', '730000'),
    ('INS03', '51000', '850000'),
    ('INS03', '63000', '680000');
    INSERT INTO insurance_plans (InsuranceId, PremiumAmount, CoverageAmount)
VALUES
    ('INS04', '65000', '920000'),
    ('INS04', '68000', '850000'),
    ('INS04', '62000', '890000'),
    ('INS04', '61000', '830000'),
    ('INS04', '64000', '960000');
        INSERT INTO insurance_plans (InsuranceId, PremiumAmount, CoverageAmount)
VALUES
    
    ('INS05', '70000', '870000'),
    ('INS05', '73000', '930000'),
    ('INS05', '69000', '910000'),
    ('INS05', '72000', '880000'),
    ('INS05', '71000', '940000');
    
    ALTER TABLE insurance_plans
ADD Paymode VARCHAR(255);
 ALTER TABLE insurance_plans
ADD InitialAmount DOUBLE;






