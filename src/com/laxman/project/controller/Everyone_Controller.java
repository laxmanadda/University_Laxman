package com.laxman.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laxman.project.entity.user;
import com.laxman.project.service.student_service;

@Controller
@RequestMapping("/")
public class Everyone_Controller {
	
	@Autowired
	private student_service stud_service;
	
	@GetMapping("/About")
	public String About_Page() {
		return "About_Page";
	}
	
	@GetMapping("/")
	public String display_welcome_page() {
		return "index";
	}
	
	@RequestMapping("/Create_Student_Account")
	public String Creating_Account(Model model) {
		user new_student=new user();
		model.addAttribute("new_student",new_student);
		return "account_creation_form";
	}
	
	@RequestMapping("/create_account")
	public String Saving_New_Account(@ModelAttribute("new_student") user new_student,Model model) {
		PasswordEncoder encoder=new BCryptPasswordEncoder();
		new_student.setPassword(encoder.encode(new_student.getPassword()));
		try {
			stud_service.save_new_student(new_student);
			return "redirect:/login";
		}catch(Exception e) {
			return "redirect:/Create_Student_Account";
		}
	}
}
