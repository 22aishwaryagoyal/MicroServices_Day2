package com.fisglobal.departmentservice;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fisglobal.departmentservice.model.Department;
import com.fisglobal.departmentservice.repository.DepartmentRepository;

@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(DepartmentServiceApplication.class, args);
		
		/*
		 * DepartmentRepository
		 * departmentRepository=context.getBean(DepartmentRepository.class); Department
		 * department=new Department(1001,"Accountant","Bangalore"); Department
		 * department1=new Department(1002,"Sales","Bangalore"); Department
		 * department2=new Department(1003,"Finance","Pune"); Department department3=new
		 * Department(1004,"Operations","Bombay");
		 * departmentRepository.save(department);
		 * departmentRepository.save(department1);
		 * departmentRepository.save(department2);
		 * departmentRepository.save(department3); List <Department>
		 * departments=departmentRepository.findAll();
		 * departments.forEach(System.out::println); context.close();
		 */
		 
		}

}
