package com.test.hibernateProj.rest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.hibernateProj.rest.model.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {

	@Query("Select s from Employee e, Salary s where e.id=s.empID and s.salary > ?1")
	public List<Salary> findHighestSal(double sal);

	@Query("Select s from Employee e, Salary s where e.id=s.empID and s.salary < :salary")
	public List<Salary> findLessSal(@Param("salary") double sal);
}
