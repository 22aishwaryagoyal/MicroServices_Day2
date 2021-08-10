package com.fisglobal.organizationalservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="org1")
public class Organizational
{
	@Id
	private long orgId;
	@Size(min=2,max=15,message="Name should contain atleast 15 chars")
	private String orgName;
	@NotNull
	private String loc;
}
