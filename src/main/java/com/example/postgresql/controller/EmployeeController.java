package com.example.postgresql.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postgresql.entity.Employee;
import com.example.postgresql.exception.ResourceNotFoundException;
import com.example.postgresql.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		return empRepo.findAll();
	}
	
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable(value="id") Long employeeId) throws ResourceNotFoundException{
		Employee employee = empRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee Resource is not found for this id"+employeeId));
		return ResponseEntity.ok().body(employee);
	}
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return empRepo.save(employee);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long employeeId, @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = empRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee Resource is not found for this id"+employeeId));
		employee.setEmpname(employeeDetails.getEmpname());
		employee.setEmpaddress(employeeDetails.getEmpaddress());
		return ResponseEntity.ok(empRepo.save(employee));
	}

}
