package com.rscoe.admissionsystem.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rscoe.admissionsystem.model.College;
import com.rscoe.admissionsystem.model.Role;
import com.rscoe.admissionsystem.repository.CollegeRepository;
import com.rscoe.admissionsystem.repository.CollegeSpecification;
import com.rscoe.admissionsystem.repository.RoleRepository;

@Service
public class CollegeService {

	private CollegeRepository collegeRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public CollegeService(CollegeRepository collegeRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.collegeRepository = collegeRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public College findCollegeByEmailId(String emailId) {
		return collegeRepository.findByEmailId(emailId);
	}

	public College findCollegeByUserName(String username) {
		return collegeRepository.findByUserName(username);
	}

	public College saveUser(College college) {
		college.setPassword(bCryptPasswordEncoder.encode(college.getPassword()));
		college.setActive(true);
		Role userRole = roleRepository.findByRole("COLLEGE");
		college.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		return collegeRepository.save(college);
	}

	public List<College> findColleges(String branchName, double marks, String categeory) {
		Specification<College> spec = Specification
				.where(CollegeSpecification.withBranchNameAndCategeory(branchName, marks, categeory));
		return collegeRepository.findAll(spec);
	}

	public List<College> findCollegesByCity(String branchName, double marks, String categeory, String city) {
		Specification<College> spec = Specification
				.where(CollegeSpecification.withBranchNameAndCategeory(branchName, marks, categeory));
		return collegeRepository.findAll(spec);
	}
}
