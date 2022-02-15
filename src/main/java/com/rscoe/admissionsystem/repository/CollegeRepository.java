package com.rscoe.admissionsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.rscoe.admissionsystem.model.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long>, JpaSpecificationExecutor<College> {

	College findByEmailId(String emailId);

	College findByUserName(String username);
	
}
