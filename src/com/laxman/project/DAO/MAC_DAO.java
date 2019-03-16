package com.laxman.project.DAO;

import java.util.List;

import com.laxman.project.entity.Application;

public interface MAC_DAO {

	List<Application> get_applications_for_mac(String program_name, String status);

	void approve_fresh_app(int app_id,int schedule_id);
	
	int get_no_applications(int schedule_id);

	void reject_app(int app_id);

	void approve_interview_app(int app_id);

}
