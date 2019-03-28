package com.laxman.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laxman.project.entity.Application;
import com.laxman.project.entity.Programs_Offered;
import com.laxman.project.entity.Programs_scheduled;
import com.laxman.project.entity.user;
import com.laxman.project.service.student_service;

@Controller
@RequestMapping("/s")
public class Student_Controller {
	
	@Autowired
	private student_service stud_service;
	
	@GetMapping("/student")
	public String redirecting_student_page(@RequestParam("user_id") int id, Model model) {
		
		List<Programs_scheduled> not_applied=stud_service.get_programs_scheduled_student_not_applied(id);
		
		List<Programs_scheduled> interview_approval_waiting=stud_service.get_programs_scheduled_student_interview_approval_waiting(id);
		
		List<Programs_scheduled> confirmation_waiting=stud_service.get_programs_scheduled_student_confirmation_waiting(id);
		
		List<Programs_scheduled> confirmed=stud_service.get_programs_scheduled_student_confirmed(id);
		
		List<Programs_scheduled> rejected=stud_service.get_programs_scheduled_student_rejected(id);
		
		model.addAttribute("not_applied", not_applied);
		model.addAttribute("fresh", interview_approval_waiting);
		model.addAttribute("interview", confirmation_waiting);
		model.addAttribute("confirmed", confirmed);
		model.addAttribute("rejected", rejected);
		model.addAttribute("user_id", id);
		
		return "student_page";
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
		test.applied_mail(app);
		model.addAttribute("user_id", app.getUser_id());
		return "redirect:/s/student";
	}
	
	
}
