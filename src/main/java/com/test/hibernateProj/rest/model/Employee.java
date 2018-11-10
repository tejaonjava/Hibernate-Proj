package com.test.hibernateProj.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee_hib")
public class Employee {
	
	@Id
	@GeneratedValue
	int id;
	@Column
	String name;
	@Column
	String address;
	@ManyToOne
	@JoinColumn(name="dept_id")
	Department dept;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}		
	
	
	public Employee(String name, String address, Department dept) {
		super();
		this.name = name;
		this.address = address;
		this.dept = dept;
	}


	public Employee(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}



	public Employee(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}


	public Department getDept() {
		return dept;
	}


	public void setDept(Department dept) {
		this.dept = dept;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
		
	}
	
	

}
