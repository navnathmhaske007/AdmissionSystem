package com.rscoe.admissionsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.rscoe.admissionsystem.model.College;
import com.rscoe.admissionsystem.model.SearchData;
import com.rscoe.admissionsystem.model.Student;
import com.rscoe.admissionsystem.service.CollegeService;
import com.rscoe.admissionsystem.service.StudentService;

@Controller
@SessionAttributes({ "student", "searchData" })
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private CollegeService collegeService;

	@ModelAttribute
	SearchData getSearchData() {
		return new SearchData();
	}

	@GetMapping(value = { "/", "/index" })
	public ModelAndView preLogin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@GetMapping(value = "/studentRegistration")
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		Student student = new Student();
		modelAndView.addObject("student", student);
		modelAndView.setViewName("studentRegistration");
		return modelAndView;
	}

	@PostMapping(value = "/studentRegistration")
	public ModelAndView createNewStudent(Student student, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Student userExists = studentService.findUserByUserName(student.getUserName());
		if (userExists != null) {
			bindingResult.rejectValue("userName", "error.user",
					"There is already a user registered with the user name provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("studentRegistration");
		} else {
			studentService.saveUser(student);
			modelAndView.addObject("successMessage", "Student has been registered successfully");
			modelAndView.addObject("student", new Student());
			modelAndView.setViewName("success");

		}
		return modelAndView;
	}

	@GetMapping(value = "/student/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Student student = studentService.findUserByUserName(auth.getName());
		modelAndView.addObject("userName", "Welcome " + student.getFirstName() + " " + student.getLastName());
		modelAndView.addObject("student", student);
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("student/home");
		return modelAndView;
	}

	@PostMapping(value = "/student/searchColleges")
	public ModelAndView searchColleges(@ModelAttribute("searchData") SearchData searchData,
			@ModelAttribute("student") Student student, BindingResult bindingResult) {
		List<College> collegeList = null;
		ModelAndView modelAndView = new ModelAndView();
		if (!searchData.getCity().equalsIgnoreCase("")) {
			collegeList = collegeService.findCollegesByCity(searchData.getBranch(), student.getCetMarks(),
					searchData.getCategeory(), searchData.getCity());
		} else {
			collegeList = collegeService.findColleges(searchData.getBranch(), student.getCetMarks(),
					searchData.getCategeory());
		}

		if (collegeList == null) {
			bindingResult.rejectValue("error", "error.user", "There is no college with this search");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("student/home");
		} else {
			modelAndView.addObject("userName", "Welcome " + student.getFirstName() + " " + student.getLastName());
			modelAndView.addObject("student", student);
			modelAndView.addObject("successMessage", "Colleges Fetched successfully");
			modelAndView.addObject("collegeList", collegeList);
			modelAndView.addObject("branch", searchData.getBranch());
			modelAndView.setViewName("student/collegeList");
		}
		return modelAndView;
	}

}
