package com.example.springbootrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrest.dao.EmpRepository;
import com.example.springbootrest.model.Employee;


@RestController
@RequestMapping("employee")
public class EmpController {

	@Autowired
	EmpRepository empRepo;
	
	@GetMapping("test")
	public String homePage() {
		System.out.println("Service is up and running...");
		return "Service is up and running...";
	}
	
	@GetMapping("")
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return empRepo.findById(id).orElse(new Employee());
	}
	
	@PostMapping("")
	public String addEmployee(@RequestBody Employee employee) {
		System.out.println("Employee:"+ employee);
		empRepo.save(employee); //returns the saved entity i.e. Employee in this case. So employee's default constructor is being invoked here.
//		Employee savedEmployee = empRepo.save(employee);//Use the returned instance for further operations as the save operation might have changed the entity instance completely
		return "Employee record saved to database";
	}
	
	@PutMapping("")
	public String updateEmployee(@RequestBody Employee employee) {
		System.out.println("Employee:"+ employee);
		empRepo.save(employee); 
		return "Employee record updated";
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable int id) {
		String msg = "";
//		Employee employee = empRepo.findById(id).orElse(null);
//		System.out.println("Employee:"+ employee);
//		if(employee != null) {
//			empRepo.delete(employee);
//			System.out.println("Employee record deleted from database.");
//		} else {
//			System.out.println("Employee not found in database.");
//		}
		
		//OR
		if(empRepo.existsById(id)) {
			empRepo.deleteById(id);
			msg = "Employee record deleted";
		}else {
			msg = "Employee record not found";
		}
		return msg;
	}
}
