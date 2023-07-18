create database submissions;
use submissions;

CREATE TABLE lead_detail (
    id INT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email_address VARCHAR(255),
    phone_number VARCHAR(20)
);



CREATE TABLE consultant_detail (
    consultant_id INT PRIMARY KEY,
    lead_id INT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email_address VARCHAR(255),
    phone_number VARCHAR(20)
);

ALTER TABLE consultant_detail
ADD FOREIGN KEY (lead_id) REFERENCES lead_detail(id)




CREATE TABLE submission (
    submission_id INT PRIMARY KEY,
    consultant_id INT,
    submission_date DATE,
    vendor_company VARCHAR(255),
    vendor_name VARCHAR(255),
    vendor_email_address VARCHAR(255),
    vendor_phone_number VARCHAR(20),
    implementation_partner VARCHAR(255),
    client_name VARCHAR(255),
    pay_rate DECIMAL(10, 2),
    submission_status VARCHAR(50),
    submission_type VARCHAR(50),
    city VARCHAR(100),
    state VARCHAR(50),
    zip VARCHAR(20)
);

ALTER TABLE submission
ADD FOREIGN KEY (consultant_id) REFERENCES consultant_detail(consultant_id)




CREATE TABLE submission_update (
    submission_update_id INT PRIMARY KEY,
    submission_id INT,
    update_text VARCHAR(255),
    created_date DATE
);

ALTER TABLE submission_update
ADD FOREIGN KEY (submission_update_id) REFERENCES submission(submission_id)



show tables 
///////
CREATE TABLE Employee (
	Employee_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    job_start_date DATE,
    salary DECIMAL(10, 2)
);


INSERT INTO Employee (Employee_id, first_name, last_name, job_start_date, salary)
VALUES
(1, 'Ravi', 'K', '2023-01-15', 55000.00),
(2, 'Ajay', 'K', '2022-02-20', 60000.00),
(3, 'Teju', 'J', '2023-03-10', 70000.00),
(4, 'Vamshi', 'B', '2022-04-05', 62000.00),
(5, 'Rahul', 'H', '2023-05-12', 58000.00);

update Employee set department="da" where Employee_id=4;

select *from Employee;

ALTER TABLE Employee
	ADD department VARCHAR(255);
    
    SELECT MAX(salary) FROM Employee;
    
    SELECT *
	FROM Employee
	WHERE job_start_date >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH);
    
    SELECT department, COUNT(*) AS employee_count
	FROM Employee
	GROUP BY department;
	
    
    INSERT INTO lead_detail (id, first_name, last_name, email_address, phone_number)
VALUES
(1, 'vinay', 'G', 'vinay@gmail.com', '555-1234'),
(2, 'prem', 'S', 'prem@gmail.com', '555-5678'),
(3, 'praveen', 'L', 'praveen@gmail.com', '555-9876'),
(4, 'tejan', 'K', 'tejan@gmail.com', '555-4321'),
(5, 'kranthi', 'B', 'kranthi@gmail.com', '555-8765');
    
    
    select *from lead_detail;

INSERT INTO consultant_detail (consultant_id, lead_id, first_name, last_name, email_address, phone_number)
VALUES
(101, 1, 'Ravi', 'k', 'ravi@gmail.com', '555-1234'),
(102, 1, 'ajay', 'k', 'ajay@gmail.com', '555-5678'),
(103, 1, 'Teju', 'j', 'Teju@gmail.com', '555-9876'),
(104, 2, 'vamshi', 'b', 'vamshi@gmail.com', '555-4321'),
(105, 3, 'rahul', 'k', 'rahul@gmail.com', '555-8765');


   select *from consultant_detail;
   
   
   INSERT INTO submission (
    submission_id,
    consultant_id,
    submission_date,
    vendor_company,
    vendor_name,
    vendor_email_address,
    vendor_phone_number,
    implementation_partner,
    client_name,
    pay_rate,
    submission_status,
    submission_type,
    city,
    state,
    zip
) VALUES
(1, 101, '2023-07-01', 'nityo', 'Rakesh', 'Rakesh@gmail.com', '555-1111', '', 'Amex', 80.00, 'Submitted', 'New', 'City A', 'State 1', '12345'),
(2, 101, '2023-07-02', 'sbase', 'padhma', 'padhma@gmail.com', '555-2222', 'delta', 'Client Y', 70.00, 'Submitted', 'New', 'City B', 'State 2', '23456'),
(3, 102, '2023-07-03', 'sbase', 'Rakesh', 'Rakesh@gmail.com', '555-3333', '', 'Bofa', 80.00, 'Submitted', 'New', 'City C', 'State 3', '34567'),
(4, 102, '2023-07-04', 'sbase', 'ram', 'ram@gmail.com', '555-4444', 'Cts', 'JPMC', 65.00, 'Submitted', 'New', 'City D', 'State 4', '45678'),
(5, 103, '2023-07-05', 'sbase', 'Rakesh', 'Rakesh@gmail.com', '555-5555', 'Dimiour', 'Amex', 75.00, 'Submitted', 'New', 'City E', 'State 5', '56789'),
(6, 103, '2023-07-06', 'nityo', 'padhma', 'padhma@gmail.com', '555-6666', '', 'captial One', 85.00, 'Submitted', 'New', 'City F', 'State 6', '67890'),
(7, 104, '2023-07-07', 'sbase', 'ram', 'ram@gmail.com', '555-7777', 'Capco', 'JPMC', 90.00, 'Submitted', 'New', 'City G', 'State 7', '78901'),
(8, 104, '2023-07-08', 'nityo', 'padhma', 'padhma@gmail.com', '555-8888', 'Partner H', 'bofa', 70.00, 'Submitted', 'New', 'City H', 'State 8', '89012'),
(9, 105, '2023-07-09', 'nityo', 'Rakesh', 'Rakesh@egmail.com', '555-9999', '', 'Fedx', 80.00, 'Submitted', 'New', 'City I', 'State 9', '90123'),
(10, 105, '2023-07-10', 'sbase', 'ram', 'ram@gmail.com', '555-0000', 'Innova', 'Amercian Airlines', 95.00, 'Submitted', 'New', 'City J', 'State 10', '01234');

select *from consultant_detail;
update consultant_detail set email_address="Teju.J@gmail.com" where  email_address="Teju@gmail.com";



SELECT consultant_id, COUNT(*) AS submissions_count
	FROM submission
	GROUP BY consultant_id;



SELECT consultant_id,submission_date, COUNT(*) AS submissions_count
	FROM submission
	GROUP BY consultant_id,submission_date;
    
    insert into submission values (12, 101, '2023-07-01', 'nityo', 'Rakesh', 'Rakesh@gmail.com', '555-1111', '', 'Amex', null, 'Submitted', 'New', 'City A', 'State 1', '12345')
    
    delete from submission where pay_rate is Null; 
    
    select *from submission;
    select *from submission where submission_date="2023-07-02" and lead_id in (select id from  lead_detail where first_name='vinay')
    
    select id  from lead_detail where first_name='vinay'
    
    
    SELECT s.*
FROM submission AS s
JOIN lead_detail AS ld 
ON s.lead_id = ld.id
WHERE ld.first_name = 'Vinay' AND s.submission_date = '2023-07-02';


SELECT s.*
FROM submission AS s
JOIN consultant_detail AS cd ON s.consultant_id = cd.consultant_id
JOIN lead_detail AS ld ON cd.lead_id = ld.id
WHERE ld.first_name = 'Vinay' AND s.submission_date = '2023-07-02';

SELECT ld.id ,count(s.submission_id)
FROM submission AS s
JOIN consultant_detail AS cd ON s.consultant_id = cd.consultant_id
JOIN lead_detail AS ld ON cd.lead_id = ld.id
Group By ld.id 
