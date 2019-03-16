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
import com.laxman.project.entity.User;
import com.laxman.project.entity.mac_dropdown;
import com.laxman.project.entity.start_end;
import com.laxman.project.service.student_service;
import com.laxman.project.service.MAC_service;
import com.laxman.project.service.admin_service;

@Controller
@SessionAttributes({"login","user"})
@RequestMapping("/")
public class Main_Controller {
	public Boolean start=false;	
	public static long start_date;
	public static long end_date;
	
	@Autowired
	private student_service stud_service;
	@Autowired
	private admin_service admin_service;
	
	//creating a session variable login
	@ModelAttribute("user")
	 public User get_user_details() {
		User new_user=new User();
		return new_user;
	 }
	@ModelAttribute("login")
	 public String get_logged_in() {
		String logged="no";
		return logged;
	 }
	
	public static void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
	@GetMapping("/About")
	public String About_Page() {
		return "About_Page";
	}
	
	@GetMapping("/login")
	public String checking_credentials(Model model, @ModelAttribute("error") String error) {
		User user=new User();
		model.addAttribute("error",error);
		model.addAttribute("new_user",user);
		return "login_form";
	}
	
	@PostMapping("/check_user")
	public String saving_customer(@SessionAttribute("login") String logged_in,@SessionAttribute("user") User current_user,@Valid @ModelAttribute("new_user") User user,BindingResult result, Model model) {
		String err_msg="";
		List<User> u =admin_service.check_login(user);
		List<start_end> process=admin_service.get_start_end();
		if(process.size()>0) {
			start=true;
			start_date=process.get(0).getStart();
			end_date=process.get(0).getEnd();
		}
		
		long today=System.currentTimeMillis();
		if(u.size()>0) {
			//saving user user_name and role into session variable login if login is successful
			current_user.setUser_name(u.get(0).getUser_name());
			current_user.setRole(u.get(0).getRole());
			
			logged_in="yes";
			System.out.println(logged_in);
			
			if(u.get(0).getRole().equalsIgnoreCase("admin")) {
				
				return "redirect:/admin";
				
			}else if(u.get(0).getRole().equalsIgnoreCase("mac")) {
				if(start) {
					if(end_date>today) {
						mac_dropdown mac_drop=new mac_dropdown();
						
						LinkedHashMap<String,String> programs_dropdown=new LinkedHashMap<String,String>();
						
						List<Programs_Offered> programs_offered=admin_service.get_programs_offered();
						
						for(Programs_Offered p:programs_offered) {
							programs_dropdown.put(p.getProgramName(), p.getProgramName());
						}
						
						mac_drop.setPrograms_dropdown(programs_dropdown);
						
						model.addAttribute("mac_drop",mac_drop );
						return "mac_page";
					}else {
						err_msg="Process has ended";
						model.addAttribute("error", err_msg);
						return "redirect:/login";
					}
				}else {
					err_msg="Application Process hasn't started";
					model.addAttribute("error", err_msg);
					return "redirect:/login";
				}
				
				
			}else if(u.get(0).getRole().equalsIgnoreCase("student")){
				if(start) {
					if(end_date>today) {
						model.addAttribute("user_id",u.get(0).getId());
						return "redirect:/student";
					}else {
						err_msg="Process has ended";
						model.addAttribute("error", err_msg);
						return "redirect:/login";
					}
				}else {
					err_msg="Application Process hasn't started";
					model.addAttribute("error", err_msg);
					return "redirect:/login";
				}	
			}else {
				return "redirect:/login";
			}
		}else {
//			if(user.getUser_name().equalsIgnoreCase("") || user.getPassword().equalsIgnoreCase("")) {
//				err_msg="User Name and Password cannot be empty";
//			}else{
				err_msg="User Name and Password Combination doesn't exists";
//			}
			
			model.addAttribute("error", err_msg);
			return "redirect:/login";
		}
	}
	
	@GetMapping("/admin")
	public String redirecting_admin_page(Model model) {
		
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
		test.send_mail();
		
		model.addAttribute("programs_offered_list", programs_offered_list);
		model.addAttribute("programs_scheduled_list", programs_scheduled_list);
		model.addAttribute("start", start);
		return "admin_page";
	}
	
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
	
	@GetMapping("/add_programs_offered")
	public String collect_program_offered(@SessionAttribute("user") User user,@SessionAttribute("login") String logged_in,Model model) {
//		System.out.println(logged_in);
//		System.out.println(user.getRole());
//		if(user.getRole().equalsIgnoreCase("admin") && logged_in.equalsIgnoreCase("yes")) {
			Programs_Offered program=new Programs_Offered();
			model.addAttribute("new_program_offered", program);
			return "add_program_offered_form";
//		}else {
//			return "redirect:/login";
//		}
		
	}
	
	@PostMapping("/save_Program_Offered")
	public String saving_program_offered(@ModelAttribute("new_program_offered") Programs_Offered program) {
		String validate=admin_service.validate_program_offered(program);
		if(validate.equalsIgnoreCase("good")) {
			admin_service.save_program_offered(program);
			return "redirect:/admin";
		}else {
			infoBox(validate,"Error while adding programs offered");
			return "redirect:/add_programs_offered";
		}
		
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
		return "redirect:/admin";
	}
	
	@GetMapping("/add_programs_scheduled")
	public String add_program_scheduled(@SessionAttribute("user") User user,@SessionAttribute("login") String logged_in,Model model) {
//		if(user.getRole().equalsIgnoreCase("admin") && logged_in.equalsIgnoreCase("yes")) {
			Programs_scheduled program=new Programs_scheduled();
			model.addAttribute("new_program_scheduled", program);
			return "add_program_scheduled_form";
//		}else {
//			return "redirect:/login";
//		}
	}
	
	@PostMapping("/save_Program_scheduled")
	public String saving_program_scheduled(@ModelAttribute("new_program_scheduled") Programs_scheduled program) {
		admin_service.save_program_scheduled(program);
		return "redirect:/admin";
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
		return "redirect:/admin";
	}

}
