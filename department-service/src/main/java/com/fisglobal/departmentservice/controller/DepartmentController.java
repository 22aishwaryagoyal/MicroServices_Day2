package com.fisglobal.departmentservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisglobal.departmentservice.exception.ResourceNotFound;
import com.fisglobal.departmentservice.model.Department;
import com.fisglobal.departmentservice.repository.DepartmentRepository;

@RestController
@RequestMapping("/api/department")
public class DepartmentController 
{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllDepartments()
	{
		List <Department> departments=departmentRepository.findAll();
		if(departments.size()>0)
		{
			return ResponseEntity.status(HttpStatus.OK).body(departments);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Records");
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getDepartmentById(@PathVariable("id") Long id) throws ResourceNotFound
	{
		Department department=departmentRepository.findById(id).orElseThrow(()->new ResourceNotFound("department not found::"+id));
		return ResponseEntity.ok().body(department);
		/*
		 * Optional<Department> optional=departmentRepository.findById(id);
		 * if(optional.isPresent()) { return
		 * ResponseEntity.status(HttpStatus.OK).body(optional.get()); } else { return
		 * ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Record Found"); }
		 */
	}
	@PostMapping("/createDepartment")
	public ResponseEntity<?> createDepartment(@RequestBody @Valid Department department)
	{
		if(departmentRepository.existsById(department.getDepartmentId()))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Record already Exists");
		}
		Department department2=departmentRepository.save(department);
		System.out.println(department2);
		if(department2!=null)
			return ResponseEntity.status(201).body(department2);
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Invalid");
		
	}
	
}
