package com.rscoe.admissionsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rscoe.admissionsystem.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByEmailId(String emailId);

	Student findByUserName(String userName);
}
