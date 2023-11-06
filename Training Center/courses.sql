CREATE DATABASE training_center;

use training_center;

CREATE TABLE courses (
    ccode VARCHAR(5) PRIMARY KEY,
    name VARCHAR(30),
    duration INT CHECK (duration >= 0),
    fee DECIMAL(5, 2) CHECK (fee >= 0),
    prerequisite VARCHAR(100)
);

INSERT INTO courses (ccode, name, duration, fee, prerequisite)
VALUES ('C001', 'Introduction to Programming', 30, 299.99, 'Basic knowledge of mathematics'),
	('C002', 'Database Design and Management', 60, 499.99, 'Basic SQL knowledge'),
    ('C003', 'Web Development Fundamentals', 45, 399.99, 'None'),
    ('C004', 'Machine Learning for Beginners', 60, 599.99, 'Basic programming skills');




CREATE TABLE faculty (
    faccode VARCHAR(5) PRIMARY KEY,
    name VARCHAR(30),
    qual VARCHAR(30),
    exp VARCHAR(100)
);


INSERT INTO FACULTY (faccode, name, qual, exp)
VALUES
    ('F101', 'Puneet Mishra', 'Bachelor of Computer Science', '8 years of teaching experience'),
    ('F102', 'Arvind Kumar', 'Master of Computer Science', '10 years of industry experience'),
    ('F103', 'Virat Kohli', 'Ph.D. in Computer Science', '15 years of research experience'),
    ('F104', 'Sanjay Patel', 'Ph.D. in Computer Science', '12 years of teaching experience');



CREATE TABLE course_faculty (
    faccode VARCHAR(5),
    ccode VARCHAR(5),
    grade CHAR(1) CHECK (grade IN ('A', 'B', 'C')),
    PRIMARY KEY (faccode, ccode),
    FOREIGN KEY (faccode) REFERENCES faculty (faccode),
    FOREIGN KEY (ccode) REFERENCES courses (ccode)
);


INSERT INTO course_faculty (faccode, ccode, grade)
VALUES
    ('F101', 'C001', 'A'),
    ('F102', 'C001', 'B'),
    ('F103', 'C002', 'A'),
    ('F104', 'C002', 'C');
    
    
    CREATE TABLE batches (
    bcode VARCHAR(5) PRIMARY KEY,
    ccode VARCHAR(5),
    faccode VARCHAR(5),
    stdate DATE,
    enddate DATE,
    timing INT(1) CHECK (timing IN (1, 2, 3)),
    FOREIGN KEY (ccode) REFERENCES courses (ccode),
    FOREIGN KEY (faccode) REFERENCES faculty (faccode),
    CHECK (stdate <= enddate)
);



INSERT INTO batches (bcode, ccode, faccode, stdate, enddate, timing)
VALUES
    ('B001', 'C001', 'F101', '2023-09-20', '2023-12-15', 1),
    ('B002', 'C002', 'F102', '2023-10-05', NULL, 2),         
    ('B003', 'C003', 'F103', '2024-02-01', NULL, 3),        
    ('B004', 'C002', 'F104', '2023-11-15', '2024-02-28', 1); 



CREATE TABLE students (
    rollno INT(5) PRIMARY KEY,
    bcode VARCHAR(5),
    name VARCHAR(30),
    gender CHAR(1) CHECK (gender IN ('M', 'F')),
    dj DATE,
    phone VARCHAR(10),
    email VARCHAR(30),
    FOREIGN KEY (bcode) REFERENCES batches (bcode)
);


INSERT INTO students (rollno, bcode, name, gender, dj, phone, email)
VALUES
    (101, 'B001', 'Rajesh Kumar', 'M', '2023-09-20', '9876543210', 'rajesh.kumar@example.com'),
    (102, 'B001', 'Priya Sharma', 'F', '2023-09-20', '7890123456', 'priya.sharma@example.com'),
    (103, 'B002', 'Amit Patel', 'M', '2023-10-05', '9988776655', 'amit.patel@example.com'),
    (104, 'B002', 'Neha Gupta', 'F', '2023-10-05', '8887776666', 'neha.gupta@example.com');


CREATE TABLE payments (
    rollno INT(5),
    dp DATE,
    amount INT(5),
    FOREIGN KEY (rollno) REFERENCES students (rollno)
);



INSERT INTO payments (rollno, dp, amount)
VALUES
    (101, '2023-09-25', 5000),  
    (102, '2023-09-26', 5500),  
    (103, '2023-10-10', 4800),  
    (104, '2023-10-12', 6000),
	 (104, '2023-10-12', 4500);



