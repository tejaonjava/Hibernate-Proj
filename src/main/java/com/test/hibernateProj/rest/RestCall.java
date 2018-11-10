package com.test.hibernateProj.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.hibernateProj.rest.model.Employee;
import com.test.hibernateProj.rest.model.Salary;

@RestController
public class RestCall {
	
	@Autowired
	HibernateService hibernateService;

	@GetMapping("/getEmp")
	public Employee getEmployee() {
		return new Employee(322,"Ashok","Kphb, Hyderabad");
	}
	
	@GetMapping("/getEmpDB")
	public Employee getEmployeeFromDB() {
		return hibernateService.getEmployee();
	}	

	@GetMapping("/getAllEmpDB")
	public List<Employee> getAllEmployeeFromDB() {
		return hibernateService.getAllEmployees();
	}	
	@GetMapping("/saveEmp")
	public Employee setEmployeeToDB() {
		hibernateService.saveEmployee(new Employee("NewEmp","Vizag"));
		return this.getEmployeeFromDB();
	}	
	
	@GetMapping("/addDep")
	public void addDepartment() {		
		hibernateService.saveDepartment();
	}
	
	@GetMapping("/addEmp")
	public void addEmployee() {		
		hibernateService.addEmployee();
	}
	
	@GetMapping("/getEmpJPA/{id}")
	public Employee getEmployeeJPA(@PathVariable("id") String id) {		
		Employee emp = hibernateService.getEmployeeJPA(new Integer(id));			
		Employee emp1 = new Employee();
		emp1.setId(emp.getId());
		emp1.setAddress(emp.getAddress());
		emp1.setName(emp.getName());
		emp1.setDept(emp.getDept());
		return emp1;
	}
	
	@GetMapping("/addSal/{empId}")
	public void addSalary(@PathVariable("empId") String empId) {
		hibernateService.addSalary(empId);
	}
	
	@GetMapping("/moreSal/{sal}")
	public List<Salary> moreSalary(@PathVariable("sal") String sal) {
		System.out.println("inside sal");
		return hibernateService.moreSalary(sal);
	}

	@GetMapping("/lessSal/{sal}")
	public List<Salary> lessSalary(@PathVariable("sal") String sal) {
		System.out.println("inside less sal");
		return hibernateService.lessSalary(sal);
	}

}
