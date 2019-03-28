package com.laxman.project.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laxman.project.entity.Application;
import com.laxman.project.entity.Programs_Offered;
import com.laxman.project.entity.mac_dropdown;
import com.laxman.project.service.MAC_service;
import com.laxman.project.service.admin_service;

@Controller
@RequestMapping("/m")
public class MAC_Controller {
	@Autowired
	private MAC_service mac_service;
	
	@Autowired
	private admin_service admin_service;
	
	@GetMapping("/mac_search")
	public String mac_shortlisting_applications(@RequestParam("program_name") String program_name,@RequestParam("status") String status, Model model) {
		System.out.println(status+" "+program_name);
		List<Application> applications=mac_service.get_applications_for_mac(program_name,status);
		
		mac_dropdown mac_drop=new mac_dropdown();
		
		LinkedHashMap<String,String> programs_dropdown=new LinkedHashMap<String,String>();
		
		List<Programs_Offered> programs_offered=admin_service.get_programs_offered();
		
		for(Programs_Offered p:programs_offered) {
			programs_dropdown.put(p.getProgramName(), p.getProgramName());
		}
		
		mac_drop.setPrograms_dropdown(programs_dropdown);
		
		model.addAttribute("mac_drop", mac_drop);
		model.addAttribute("applications",applications );
		model.addAttribute("status",status);
		model.addAttribute("program_name",program_name);
		
		if(applications.size()>0) {
			if(status.equals("fresh")) {
				return "mac_fresh_applications_page";
			}else if(status.equals("interview")) {
				return "mac_interview_applications_page";
			}else if(status.equals("confirmed")) {
				return "mac_confirmed_applications_page";
			}else {
				return "mac_rejected_applications_page";
			}
		}else {
			return "mac_page";
		}
		
	}	
	
	
	@GetMapping("/approve_fresh_app")
	public String approve_fresh_applications(@RequestParam("App_id") int app_id,@RequestParam("schedule_id") int schedule_id,Model model) {
		mac_service.approve_fresh_app(app_id,schedule_id);
		Test test=new Test();
		test.approved_mail(app_id);
		model.addAttribute("status", "fresh");
		model.addAttribute("program_name", "biology");
		return "redirect:/m/mac_search";
	}
	
	@GetMapping("/reject_app")
	public String reject_fresh_applications(@RequestParam("App_id") int app_id) {
		mac_service.reject_app(app_id);
		Test test=new Test();
		//test.send_mail();
		return "redirect:/m/mac_search";
	}
	
	@GetMapping("/approve_interview_app")
	public String approve_interview_applications(@RequestParam("App_id") int app_id) {
		mac_service.approve_interview_app(app_id);
		Test test=new Test();
		test.confirmation_mail(app_id);
		return "redirect:/m/mac_search";
	}

}
