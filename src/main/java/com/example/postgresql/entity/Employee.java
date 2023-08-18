package com.example.postgresql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp",schema = "employee")
public class Employee {
	
	@Id
	@Column(name="empid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empid;
	
	@Column(name="empname")
	private String empname;
	
	@Column(name="empaddress")
	private String empaddress;

	public long getEmpid() {
		return empid;
	}

	public void setEmpid(long empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpaddress() {
		return empaddress;
	}

	public void setEmpaddress(String empaddress) {
		this.empaddress = empaddress;
	}

	
	public Employee(String empname, String empaddress) {
		super();
		this.empname = empname;
		this.empaddress = empaddress;
	}

	public Employee() {
		super();
	}
	
	
	
	

}
