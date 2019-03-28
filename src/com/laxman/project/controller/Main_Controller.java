package com.laxman.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.laxman.project.entity.Application;
import com.laxman.project.entity.Programs_Offered;
import com.laxman.project.entity.Programs_scheduled;
import com.laxman.project.entity.user;
import com.laxman.project.entity.mac_dropdown;
import com.laxman.project.entity.start_end;
import com.laxman.project.service.student_service;
import com.laxman.project.service.MAC_service;
import com.laxman.project.service.admin_service;

@Controller
@SessionAttributes({"user"})
@RequestMapping("/a")
public class Main_Controller {
	public Boolean start=false;	
	public static long start_date;
	public static long end_date;
	
	@Autowired
	private student_service stud_service;
	@Autowired
	private admin_service admin_service;
	
//	@GetMapping("/login")
//	public String checking_credentials(Model model, @ModelAttribute("error") String error) {
//		user user=new user();
//		model.addAttribute("error",error);
//		model.addAttribute("new_user",user);
//		return "login_form";
//	}
	
//	@PostMapping("/check_user")
//	public String saving_customer(@Valid @ModelAttribute("new_user") user user,BindingResult result, Model model) {
//		String err_msg="";
//		List<user> u =admin_service.check_login(user);
//		List<start_end> process=admin_service.get_start_end();
//		if(process.size()>0) {
//			start=true;
//			start_date=process.get(0).getStart();
//			end_date=process.get(0).getEnd();
//		}
//		
//		long today=System.currentTimeMillis();
//		if(u.size()>0) {			
//			if(u.get(0).getRole().equalsIgnoreCase("admin")) {
//				
//				return "redirect:/a/admin";
//				
//			}else if(u.get(0).getRole().equalsIgnoreCase("mac")) {
//				if(start) {
//					if(end_date>today) {
//						mac_dropdown mac_drop=new mac_dropdown();
//						
//						LinkedHashMap<String,String> programs_dropdown=new LinkedHashMap<String,String>();
//						
//						List<Programs_Offered> programs_offered=admin_service.get_programs_offered();
//						
//						for(Programs_Offered p:programs_offered) {
//							programs_dropdown.put(p.getProgramName(), p.getProgramName());
//						}
//						
//						mac_drop.setPrograms_dropdown(programs_dropdown);
//						
//						model.addAttribute("mac_drop",mac_drop );
//						return "mac_page";
//					}else {
//						err_msg="Process has ended";
//						model.addAttribute("error", err_msg);
//						return "redirect:/a/login";
//					}
//				}else {
//					err_msg="Application Process hasn't started";
//					model.addAttribute("error", err_msg);
//					return "redirect:/a/login";
//				}
//				
//				
//			}else if(u.get(0).getRole().equalsIgnoreCase("student")){
//				if(start) {
//					if(end_date>today) {
//						model.addAttribute("user_id",u.get(0).getId());
//						return "redirect:/student";
//					}else {
//						err_msg="Process has ended";
//						model.addAttribute("error", err_msg);
//						return "redirect:/login";
//					}
//				}else {
//					err_msg="Application Process hasn't started";
//					model.addAttribute("error", err_msg);
//					return "redirect:/login";
//				}	
//			}else {
//				return "redirect:/login";
//			}
//		}else {
//			err_msg="User Name and Password Combination doesn't exists";	
//			model.addAttribute("error", err_msg);
//			return "redirect:/login";
//		}
//	}
	
	@GetMapping("/admin")
	public String redirecting_admin_page(Model model) {
		
		List<start_end> process=admin_service.get_start_end();
    	if(process.size()>0) {
			start=true;
		}
		
		List<Programs_Offered> programs_offered_list=admin_service.get_programs_offered();
		List<Programs_scheduled> programs_scheduled_list= admin_service.get_programs_scheduled(); 
		
		model.addAttribute("programs_offered_list", programs_offered_list);
		model.addAttribute("programs_scheduled_list", programs_scheduled_list);
		model.addAttribute("start", start);
		
		return "admin_page";
	}
	
	@GetMapping("/admin_start")
	public String redirecting_admin_page_start(Model model) {
		start=true;
		List<Programs_Offered> programs_offered_list=admin_service.get_programs_offered();
		List<Programs_scheduled> programs_scheduled_list= admin_service.get_programs_scheduled(); 
		
		start_date=System.currentTimeMillis();
		end_date=start_date+TimeUnit.DAYS.toMillis(30l);
		
		start_end process=new start_end();
		process.setStart(start_date);
		process.setEnd(end_date);
		admin_service.save_start_end(process);
		
		Test test=new Test();
		test.send_mail("start_process");
		
		model.addAttribute("programs_offered_list", programs_offered_list);
		model.addAttribute("programs_scheduled_list", programs_scheduled_list);
		model.addAttribute("start", start);
		return "admin_page";
	}
	
	
	
	@GetMapping("/add_programs_offered")
	public String collect_program_offered(Model model) {
		Programs_Offered program=new Programs_Offered();
		model.addAttribute("new_program_offered", program);
		return "add_program_offered_form";		
	}
	
	@PostMapping("/save_Program_Offered")
	public String saving_program_offered(@ModelAttribute("new_program_offered") Programs_Offered program) {
		admin_service.save_program_offered(program);
		Test test=new Test();
		test.send_mail("program_offered");
		return "redirect:/a/admin";		
	}
	
	@GetMapping("/update_programs_offered")
	public String updating_program_offered(@RequestParam("program_name") String program_name, Model model) {
		Programs_Offered program=admin_service.get_program_offered(program_name);
		System.out.println(program.getProgramName());
		model.addAttribute("new_program_offered",program);
		return "add_program_offered_form";
	}
	
	@GetMapping("/delete_programs_offered")
	public String Deleting_program_offered(@RequestParam("program_name") String program_name, Model model) {
		admin_service.delete_program_offered(program_name);
		return "redirect:/a/admin";
	}
	
	@GetMapping("/add_programs_scheduled")
	public String add_program_scheduled(Model model) {
			Programs_scheduled program=new Programs_scheduled();
			model.addAttribute("new_program_scheduled", program);
			return "add_program_scheduled_form";
	}
	
	@PostMapping("/save_Program_scheduled")
	public String saving_program_scheduled(@ModelAttribute("new_program_scheduled") Programs_scheduled program) {
		admin_service.save_program_scheduled(program);
		Test test=new Test();
		test.send_mail("program_scheduled");
		return "redirect:/a/admin";
	}
	
	@GetMapping("/update_programs_scheduled")
	public String updating_program_scheduled(@RequestParam("schedule_id") int schedule_id, Model model) {
		Programs_scheduled program=admin_service.get_program_scheduled(schedule_id);
		model.addAttribute("new_program_scheduled",program);
		return "add_program_offered_form";
	}
	
	@GetMapping("/delete_programs_scheduled")
	public String Deleting_program_scheduled(@RequestParam("schedule_id") int schedule_id, Model model) {
		admin_service.delete_program_scheduled(schedule_id);
		return "redirect:/a/admin";
	}

}
