# postgresSQl
This repo is basically use for developing spring boot JPA along with some customization for postgresSQL
SQL code to create table with foreign key reference
For Example MASTER TABLE name : DEPT or EMP
CREATE TABLE DEPT(DEPTID int PRIMARY KEY,DEPTNAME VARCHAR(100));
or
**-- Table: employee.emp

-- DROP TABLE IF EXISTS employee.emp;

CREATE TABLE IF NOT EXISTS employee.emp
(
    empid integer NOT NULL DEFAULT nextval('employee.emp_empid_seq'::regclass),
    empname character varying(50) COLLATE pg_catalog."default" NOT NULL,
    empaddress character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT emp_pkey PRIMARY KEY (empid),
    CONSTRAINT emp_empaddress_key UNIQUE (empaddress),
    CONSTRAINT emp_empname_key UNIQUE (empname)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS employee.emp
    OWNER to postgres;**

