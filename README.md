CREATE DATABASE 'DTBExam';
USE DTBExam;

create table employees (
id  int(3) NOT NULL AUTO_INCREMENT,
full_name varchar(120) NOT NULL,
birthday varchar(220),
address varchar(120),
position varchar(220),
department varchar(120),
PRIMARY KEY (id)
);