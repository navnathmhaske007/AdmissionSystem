package com.rscoe.admissionsystem.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.rscoe.admissionsystem.model.College;
import com.rscoe.admissionsystem.model.Role;
import com.rscoe.admissionsystem.model.Student;

@Service
public class StudentDetailsService implements UserDetailsService {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CollegeService collegeService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) {
		Student student = studentService.findUserByUserName(userName);
		if (null == student) {
			College college = collegeService.findCollegeByUserName(userName);
			List<GrantedAuthority> authorities = getUserAuthority(college.getRoles());
			return buildCollegeUserForAuthentication(college, authorities);
		}
		List<GrantedAuthority> authorities = getUserAuthority(student.getRoles());
		return buildUserForAuthentication(student, authorities);
	}

	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
		Set<GrantedAuthority> roles = new HashSet<>();
		for (Role role : userRoles) {
			roles.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return new ArrayList<>(roles);
	}

	private UserDetails buildUserForAuthentication(Student student, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(student.getUserName(), student.getPassword(),
				student.getActive(), true, true, true, authorities);
	}
	
	private UserDetails buildCollegeUserForAuthentication(College college, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(college.getUserName(), college.getPassword(),
				college.getActive(), true, true, true, authorities);
	}
}
