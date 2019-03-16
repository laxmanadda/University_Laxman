package com.laxman.project.service;

import java.util.List;

import com.laxman.project.entity.Application;

public interface MAC_service {
	public List<Application> get_applications_for_mac(String program_name, String status);

	public void approve_fresh_app(int app_id,int schedule_id);

	public void reject_app(int app_id);

	public void approve_interview_app(int app_id);
}
