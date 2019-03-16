package com.laxman.project.entity;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laxman.project.service.admin_service;
import com.laxman.project.service.admin_serviceImpl;

public class mac_dropdown {
	@Autowired
	private admin_service admin_service;
	
	private String status;
	private String program_name;
	
	private LinkedHashMap<String,String> programs_dropdown;
	private LinkedHashMap<String,String> status_dropdown;
	
	
	public mac_dropdown() {
		programs_dropdown=new LinkedHashMap<String,String>();
		status_dropdown=new LinkedHashMap<>();
		 
		status_dropdown.put("fresh", "new_applications");
		status_dropdown.put("interview", "interview_applications");
		status_dropdown.put("confirmed", "confirmed_applications");
		status_dropdown.put("rejected", "confirmed_applications");
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProgram_name() {
		return program_name;
	}

	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}

	public LinkedHashMap<String, String> getPrograms_dropdown() {
		return programs_dropdown;
	}

	public void setPrograms_dropdown(LinkedHashMap<String, String> programs_dropdown) {
		this.programs_dropdown = programs_dropdown;
	}

	public LinkedHashMap<String, String> getStatus_dropdown() {
		return status_dropdown;
	}
	
}
