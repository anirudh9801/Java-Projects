drop database if exists assignment;
 create database assignment;
  use assignment;
  
  drop table if exists Hotel;
  
  
 CREATE TABLE Hotel (
    CustomerID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerName VARCHAR(255) NOT NULL,
    CheckInDate DATE NOT NULL,
    CheckOutDate DATE NOT NULL,
    RoomNumber INT NOT NULL
);

insert into Hotel(CustomerName,CheckInDate,CheckOutDate,RoomNumber)
values('Amit Patel', '2023-09-25', '2023-09-30', 101),
       ('Priya Sharma', '2023-09-26', '2023-09-28', 102),
       ('Rajesh Kumar', '2023-09-27', '2023-10-02', 103),
       ('Neha Gupta', '2023-09-28', '2023-10-01', 104),
       ('Deepak Singh', '2023-09-29', '2023-10-03', 105),
       ('Anjali Sharma', '2023-09-30', '2023-10-05', 106),
       ('Pooja Mehta', '2023-10-02', '2023-10-04', 108);
     
     