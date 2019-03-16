package com.laxman.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laxman.project.DAO.MAC_DAO;
import com.laxman.project.DAO.admin_DAO;
import com.laxman.project.entity.Application;

@Service
public class MAC_serviceImpl implements MAC_service {
	
	@Autowired
	private MAC_DAO mac_dao;
	
	@Override
	public List<Application> get_applications_for_mac(String program_name, String status) {
		return mac_dao.get_applications_for_mac(program_name,status);
	}

	@Override
	public void approve_fresh_app(int app_id,int schedule_id) {
		mac_dao.approve_fresh_app(app_id,schedule_id);
	}

	@Override
	public void reject_app(int app_id) {
		mac_dao.reject_app(app_id);
	}

	@Override
	public void approve_interview_app(int app_id) {
		mac_dao.approve_interview_app(app_id);
	}
	
}
