package com.laxman.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laxman.project.entity.Application;
import com.laxman.project.entity.Programs_Offered;
import com.laxman.project.entity.User;
import com.laxman.project.service.student_service;

@Controller
@RequestMapping("/")
public class Student_Controller {
	
	@Autowired
	private student_service stud_service;
	
	@RequestMapping("/Create_Student_Account")
	public String Creating_Account(Model model) {
		User new_student=new User();
		model.addAttribute("new_student",new_student);
		return "account_creation_form";
	}
	
	@RequestMapping("/create_account")
	public String Saving_New_Account(@ModelAttribute("new_student") User new_student,Model model) {
		stud_service.save_new_student(new_student);
		return "redirect:/login";
	}
	
	@RequestMapping("/form_for_apply")
	public String Form_for_apply(@RequestParam("program_schedule_id") int id,@RequestParam("user_id") int user_id, Model model) {
		Application app=new Application();
		app.setSchedule_program_id(id);
		app.setUser_id(user_id);
		model.addAttribute("new_app", app);
		return "course_application_form";
	}
	
	@RequestMapping("/save_application")
	public String Save_course_application(@ModelAttribute("new_app") Application app,Model model) {
		app.setStatus("fresh");
		stud_service.save_application(app);
		
		Test test=new Test();
		test.send_mail();
		model.addAttribute("user_id", app.getUser_id());
		return "redirect:/student";
	}
	
	
}
