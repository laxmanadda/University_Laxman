package com.laxman.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laxman.project.DAO.admin_DAO;
import com.laxman.project.DAO.admin_DAOImpl;
import com.laxman.project.entity.Application;
import com.laxman.project.entity.Programs_Offered;
import com.laxman.project.entity.Programs_scheduled;
import com.laxman.project.entity.User;
import com.laxman.project.entity.start_end;

@Service
public class admin_serviceImpl implements admin_service{
	
	@Autowired
	private admin_DAO user_dao;
	
	
	@Override
	public List<User> check_login(User user) {
		return user_dao.check_login(user);
	}

	@Override
	public List<Programs_Offered> get_programs_offered() {
		return user_dao.get_programs_offered();
	}

	@Override
	public List<Programs_scheduled> get_programs_scheduled() {
		return user_dao.get_programs_scheduled();
	}

	@Override
	public void save_program_offered(Programs_Offered program) {
		user_dao.save_program_offered(program);
	}

	@Override
	public Programs_Offered get_program_offered(String program_name) {
		return user_dao.get_program_offered(program_name);
	}

	@Override
	public void delete_program_offered(String program_name) {
		user_dao.delete_program_offered(program_name);		
	}

	@Override
	public void save_program_scheduled(Programs_scheduled program) {
		user_dao.save_program_scheduled(program);
	}

	@Override
	public Programs_scheduled get_program_scheduled(int schedule_id) {
		
		return user_dao.get_program_scheduled(schedule_id);
	}

	@Override
	public void delete_program_scheduled(int schedule_id) {
		user_dao.delete_program_scheduled(schedule_id);
	}

	@Override
	public List<start_end> get_start_end() {
		
		return user_dao.get_start_end();
	}

	@Override
	public void save_start_end(start_end process) {
		user_dao.save_start_end(process);
	}

	@Override
	public String validate_program_offered(Programs_Offered program) {
		return (program.getDuration()>0 )? "good":"duration should be greater than 0";
	}
	
}
