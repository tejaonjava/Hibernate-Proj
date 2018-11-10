package com.test.hibernateProj.rest;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.hibernateProj.rest.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
