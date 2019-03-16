package com.laxman.project.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laxman.project.entity.Test_validation;

@Controller
@RequestMapping("/")
public class Test_Controller {
	@RequestMapping("/show_form")
	public String test_method(Model model) {
		Test_validation c=new Test_validation();
		model.addAttribute("new_user",c);
		return "test_form";
	}
	
	@RequestMapping("/check_user_validation")
	public String test_method_1(@Valid @ModelAttribute("new_user") Test_validation t,BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/show_form";
		}else {
			System.out.println("it came here");
			return "success";
		}
	}
}
