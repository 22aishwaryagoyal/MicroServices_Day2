package com.fisglobal.organizationalservice.controller;

import java.util.List;

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
import com.fisglobal.organizationalservice.model.Organizational;
import com.fisglobal.organizationalservice.repository.OrganizationalRepository;


@RestController
@RequestMapping("/api/organizational")
public class OrganizationalController
{
	@Autowired
	private OrganizationalRepository organizationalRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllOrganizations()
	{
		List <Organizational> organizationals=organizationalRepository.findAll();
		if(organizationals.size()>0)
		{
			return ResponseEntity.status(HttpStatus.OK).body(organizationals);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Records");
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getDepartmentById(@PathVariable("id") Long id) throws com.fisglobal.organizationalservice.exception.ResourceNotFound
	{
		Organizational organizational=organizationalRepository.findById(id).orElseThrow(()->new com.fisglobal.organizationalservice.exception.ResourceNotFound("organization not found::"+id));
		return ResponseEntity.ok().body(organizational);
		/*
		 * Optional<Department> optional=departmentRepository.findById(id);
		 * if(optional.isPresent()) { return
		 * ResponseEntity.status(HttpStatus.OK).body(optional.get()); } else { return
		 * ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Record Found"); }
		 */
	}
	@PostMapping("/createOrganization")
	public ResponseEntity<?> createDepartment(@RequestBody @Valid Organizational organizational)
	{
		if(organizationalRepository.existsById(organizational.getOrgId()))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Record already Exists");
		}
		Organizational organizational2=organizationalRepository.save(organizational);
		System.out.println(organizational2);
		if(organizational2!=null)
			return ResponseEntity.status(201).body(organizational2);
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Invalid");
		
	}
	
}
