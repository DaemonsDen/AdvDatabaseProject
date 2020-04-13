DROP TABLE employees IF EXISTS;
DROP TABLE dependents IF EXISTS;
DROP TABLE insurance IF EXISTS;
DROP TABLE role IF EXISTS;

CREATE TABLE employees (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30)
);
CREATE INDEX employees_last_name ON employees (last_name);

CREATE TABLE employeedependents (
  id   INTEGER IDENTITY PRIMARY KEY,
  employee_num  INTEGER,
  first_name 	VARCHAR(30),
  last_name  	VARCHAR(30),
  DOB			VARCHAR(30),
  SSN			VARCHAR(12)
);

CREATE TABLE insurance (
  insuranceId		INTEGER IDENTITY PRIMARY KEY,
  visionInsurance	VARCHAR(30),
  dentalInsurance	VARCHAR(30),
  healthInsurance	VARCHAR(30)
);

CREATE TABLE role (
  roleId			INTEGER IDENTITY PRIMARY KEY,
  description		VARCHAR(30),
  createdDate		DATE
);