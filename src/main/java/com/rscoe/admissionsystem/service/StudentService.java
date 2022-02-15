package com.rscoe.admissionsystem.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rscoe.admissionsystem.model.Role;
import com.rscoe.admissionsystem.model.Student;
import com.rscoe.admissionsystem.repository.RoleRepository;
import com.rscoe.admissionsystem.repository.StudentRepository;

@Service
public class StudentService {

	
	private StudentRepository studentRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public StudentService(StudentRepository studentRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.studentRepository = studentRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public Student findUserByEmailId(String emailId) {
		return studentRepository.findByEmailId(emailId);
	}

	

	public Student findUserByUserName(String userName) {
		return studentRepository.findByUserName(userName);
	}

	public Student saveUser(Student student) {
		student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
		student.setActive(true);
		Role userRole = roleRepository.findByRole("STUDENT");
		student.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		return studentRepository.save(student);
	}
}

