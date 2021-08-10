package com.fisglobal.organizationalservice;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fisglobal.organizationalservice.model.Organizational;
import com.fisglobal.organizationalservice.repository.OrganizationalRepository;


@SpringBootApplication
public class OrganizationalServiceApplication {

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext context=SpringApplication.run(OrganizationalServiceApplication.class,args);
		/*
		 * OrganizationalRepository
		 * organizationalRepository=context.getBean(OrganizationalRepository.class);
		 * Organizational organizational=new
		 * Organizational(5001,"FisGlobal","Bangalore"); Organizational
		 * organizational1=new Organizational(5002,"Global","Pune"); Organizational
		 * organizational2=new Organizational(5003,"Oracle","Bombay"); Organizational
		 * organizational3=new Organizational(5004,"Tcs","Bangalore");
		 * organizationalRepository.save(organizational);
		 * organizationalRepository.save(organizational1);
		 * organizationalRepository.save(organizational2);
		 * organizationalRepository.save(organizational3); List <Organizational>
		 * organizationals=organizationalRepository.findAll();
		 * organizationals.forEach(System.out::println); context.close();
		 */
		
	}

}
