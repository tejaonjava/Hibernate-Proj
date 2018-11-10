package com.test.hibernateProj.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salary")
public class Salary {
	
	@Id
	@GeneratedValue
	int id;
	@Column
	int empID;
	@Column
	double salary;
	@Column
	String bankName;
	@Column
	int acctNo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	
	public int getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(int acctNo) {
		this.acctNo = acctNo;
	}
	@Override
	public String toString() {
		return "Salary [id=" + id + ", empID=" + empID + ", salary=" + salary + ", bankName=" + bankName + ", acctNo="
				+ acctNo + "]";
	}
	
}
