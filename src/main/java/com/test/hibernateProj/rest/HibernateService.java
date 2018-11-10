package com.test.hibernateProj.rest;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.hibernateProj.rest.model.Department;
import com.test.hibernateProj.rest.model.Employee;
import com.test.hibernateProj.rest.model.Salary;

@Service
public class HibernateService {
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	SalaryRepository salaryRepository;
	
	Random random = new Random();
	
	public Employee getEmployee() {
		Query query = entityManager.createQuery("from Employee emp");
		Employee emp = (Employee)query.getResultList().get(0);		
		return emp;
	}

	public Department getDepartment() {
		Query query = entityManager.createQuery("from Department dep");
		Department dep = (Department)query.getResultList().get(0);
		return dep;
	}
	
	@Transactional
	public void saveEmployee(Employee emp) {
		System.out.println("Enter save");
		emp.setDept(getDepartment());
		System.out.println("Enter got dept "+emp);
		entityManager.persist(emp);
	}

	@Transactional
	public void saveDepartment() {
		entityManager.persist(new Department("HR"));		
	}

	@Transactional
	public void saveDepartment(Department dep) {
		entityManager.persist(dep);
		
	}

	public List<Employee> getAllEmployees() {
		Query query = entityManager.createQuery("from Employee emp");
		List<Employee> employees = (List<Employee>)query.getResultList();		
		return employees;

	}

	@Transactional
	public void addEmployee() {
	 Employee emp =new Employee();
	 emp.setName("AddName"+ random.nextInt(1000));
	 emp.setAddress("AddAddress"+random.nextInt(100));
	 Department dep = new Department();
	 //dep.setId(random.nextInt(1000));
	 dep.setName("Dept"+random.nextInt(1000));	
	 saveDepartment(dep);
	 emp.setDept(dep);	 
	 entityManager.persist(emp);
		
	}

	public Employee getEmployeeJPA(Integer id) {		
		return employeeRepository.getOne(id);
	}

	public void addSalary(String empId) {
		Salary sal = new Salary();
		sal.setEmpID(Integer.parseInt(empId));
		sal.setAcctNo(random.nextInt(100000000));
		sal.setBankName("MyBank"+random.nextInt(3));
		sal.setSalary(random.nextInt(100000000));
		salaryRepository.save(sal);
	}

	public List<Salary> moreSalary(String sal) {
		return salaryRepository.findHighestSal(Double.parseDouble(sal));
	}
}
