package com.fisglobal.departmentservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="dept1")
public class Department
{
	@Id
	private long departmentId;
	@Size(min=2,max=15,message="Name should be atleast 2 chars")
	private String departmentName;
	@Email
	private String email;
	@NotNull
	private String location;
	@Positive
	@NonNull
	private float salary;
}
