



create database hms;
use hms;
create table DOCTOR_MASTER 
       (
         Dr_id varchar(15) unique not NULL,
         Dr_name varchar(15) not null,
         Dept varchar(15) not null,
         constraint d_pk primary key(Dr_id)
        );  
insert into DOCTOR_MASTER(Dr_id,Dr_name,Dept)
values
('D0001','Ram','ENT'),
('D0002','Rajan','ENT'),
('D0003','Samita','Eye'),
('D0004','Bhavan','Surgery'),
('D0005','Sheela','Surgery'),
('D0006','Nethra','Surgery');

select * from DOCTOR_MASTER;
create table room_master  
       (
         room_no varchar(15) unique not NULL,
         room_type varchar(15) not null,
         status varchar(15) not null
        );  

        select * from room_master;
insert into room_master(room_no,room_tyPe,status)
values
('R0001','AC','OCCUPIED'),
('R0002','SUITE','VACANT'),
('R0003','NONAC','VACANT'),
('R0004','NONAC','OCCUPIED'),
('R0005','AC','VACANT'),
('R0006','AC','OCCUPIED');

create table patient_master   
       (
         pid varchar(15) unique not NULL,
         name varchar(15) not null,
         age int(15) not null,
         weight  int(15) not null,
         gender varchar(10) not null,
         address varchar(50) not null,
         phoneno varchar(10) not null,
         disease varchar(50) not null,
doctor_id varchar(5)
        );  

insert into patient_master(pid,name,age,weight, gender, address,phoneno,disease,Doctor_id)
values
('P0001','gita',35,65,'f','chennai','9867145678','eye infection','D0003'),
('P0002','Ashish',40,70,'m','delhi','9845675678','asthma','D0003'),
('P0003','radha',25,60,'f','chennai','9867166678','pain in heart','D0005'),
('P0004','chnadra',28,55,'f','Banglore','9978675567','asthma','D0001'),
('P0005','Goyal',42,65,'m','delhi','8967533223','pain in stomach','D0004')
;
USE hms; -- Use the hms database

-- Add the new columns to the patient_master table
ALTER TABLE patient_master
ADD Email VARCHAR(50),
ADD OTP VARCHAR(10),
ADD Password VARCHAR(20),
ADD Status VARCHAR(15);

USE hms; 
ALTER TABLE patient_master
DROP COLUMN Email,
DROP COLUMN OTP,
DROP COLUMN Password,
DROP COLUMN Status;

USE hms; -- Use the hms database

-- Add the new columns to the patient_master table
ALTER TABLE patient_master
ADD Email VARCHAR(50)not null,
ADD OTP VARCHAR(10)not null,
ADD Password VARCHAR(20)not null,
ADD Status VARCHAR(15)not null;
USE hms; 
ALTER TABLE patient_master
DROP COLUMN email,
DROP COLUMN otp,
DROP COLUMN password,
DROP COLUMN status;
USE hms; -- Use the hms database

-- Add the new columns to the patient_master table
ALTER TABLE patient_master
ADD email VARCHAR(50),
ADD otp VARCHAR(10),
ADD password VARCHAR(20),
ADD status VARCHAR(15);


select * from patient_master;
create table ROOM_ALLOCATION 
       (
         room_no varchar(15),
         pid varchar(15) ,
         admission_date date not null,
         Release_date date
        );  

insert into ROOM_ALLOCATION (room_no,pid, admission_date,Release_date)
values
('R0001','P0001','2016-10-15','2016-10-26'),
('R0002','P0002','2016-11-15','2016-11-26'),
('R0003','P0003','2016-12-01','2016-12-30'),
('R0004','P0004','2017-01-01','2017-01-30')
;
select * from ROOM_ALLOCATION;