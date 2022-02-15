package com.rscoe.admissionsystem.controller;

import java.util.HashSet;
import java.util.Set;

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

import com.rscoe.admissionsystem.model.Branches;
import com.rscoe.admissionsystem.model.College;
import com.rscoe.admissionsystem.model.SearchData;
import com.rscoe.admissionsystem.service.BranchService;
import com.rscoe.admissionsystem.service.CollegeService;

@Controller
@SessionAttributes({ "college", "searchData" })
public class CollegeController {

	@Autowired
	private CollegeService collegeService;

	@Autowired
	private BranchService branchService;

	@ModelAttribute
	SearchData getSearchData() {
		return new SearchData();
	}

	@GetMapping(value = "/collegeRegistration")
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		College college = new College();
		modelAndView.addObject("college", college);
		modelAndView.setViewName("collegeRegistration");
		return modelAndView;
	}

	@PostMapping(value = "/collegeRegistration")
	public ModelAndView createNewStudent(College college, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		College userExists = collegeService.findCollegeByUserName(college.getUserName());
		if (userExists != null) {
			bindingResult.rejectValue("userName", "error.user",
					"There is already a College registered with the user name provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("collegeRegistration");
		} else {
			collegeService.saveUser(college);
			modelAndView.addObject("successMessage", "College has been registered successfully");
			modelAndView.addObject("college", new College());
			modelAndView.setViewName("success");

		}
		return modelAndView;
	}

	@GetMapping(value = "/college/home")
	public ModelAndView collegeHome() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		College college = collegeService.findCollegeByUserName(auth.getName());
		modelAndView.addObject("userName", "Welcome " + college.getCollegeName());
		modelAndView.addObject("collegeMessage", "Content Available Only for Users with College Role");
		modelAndView.addObject("college", college);
		modelAndView.setViewName("college/home");
		return modelAndView;
	}

	@PostMapping(value = "/college/addMarks")
	public ModelAndView addMarks(@ModelAttribute("searchData") SearchData searchData,
			@ModelAttribute("college") College college, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		College userExists = collegeService.findCollegeByUserName(college.getUserName());
		if (userExists == null) {
			bindingResult.rejectValue("userName", "error.user",
					"There is already a College registered with the user name provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("college/home");
		} else {
			Branches branches = new Branches();
			branches.setCategeory(searchData.getCategeory());
			branches.setCivil(searchData.getCivil());
			branches.setComputer(searchData.getComputer());
			branches.setElectrical(searchData.getElectrical());
			branches.setEntc(searchData.getEntc());
			branches.setIt(searchData.getIt());
			branches.setMechanical(searchData.getMechanical());
			Set<Branches> set = new HashSet<Branches>();
			set.add(branches);
			// userExists.setSetOfBranches(set);
			branches.setCollege(college);
			//collegeService.saveUser(userExists);
			branchService.saveUser(branches);
			modelAndView.addObject("userName", "Welcome " + college.getCollegeName());
			modelAndView.addObject("successMessage",
					"Data has been registered successfully... You can add more if you want");
			modelAndView.addObject("college", college);
			modelAndView.setViewName("college/home");

		}
		return modelAndView;
	}

	
}
