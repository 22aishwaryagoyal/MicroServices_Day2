package com.fisglobal.organizationalservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fisglobal.organizationalservice.model.Organizational;

@Repository
public interface OrganizationalRepository extends JpaRepository<Organizational, Long>
{

}
