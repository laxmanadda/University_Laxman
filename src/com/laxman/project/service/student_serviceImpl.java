package com.laxman.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laxman.project.DAO.student_DAO;
import com.laxman.project.DAO.student_DAOImpl;
import com.laxman.project.entity.Application;
import com.laxman.project.entity.Programs_scheduled;
import com.laxman.project.entity.user;

@Service
public class student_serviceImpl implements student_service {
	
	@Autowired
	private student_DAO student_dao;

	@Override
	public List<Programs_scheduled> get_programs_scheduled_student_not_applied(int id) {
		
		return student_dao.get_programs_scheduled_student_not_applied(id);
	}

	@Override
	public void save_new_student(user student) {
		student_dao.save_new_student(student);
	}

	@Override
	public void save_application(Application app) {
		student_dao.save_application(app);		
	}

	@Override
	public List<Programs_scheduled> get_programs_scheduled_student_interview_approval_waiting(int id) {
		return student_dao.get_programs_scheduled_student_interview_approval_waiting(id);
	}

	@Override
	public List<Programs_scheduled> get_programs_scheduled_student_confirmation_waiting(int id) {
		return student_dao.get_programs_scheduled_student_confirmation_waiting(id);
	}

	@Override
	public List<Programs_scheduled> get_programs_scheduled_student_confirmed(int id) {
		return student_dao.get_programs_scheduled_student_confirmed(id);
	}

	@Override
	public List<Programs_scheduled> get_programs_scheduled_student_rejected(int id) {
		return student_dao.get_programs_scheduled_student_rejected(id);
	}

	@Override
	public String[] get_students_email() {		
		return student_dao.get_students_email();
	}

	@Override
	public List<Application> get_student(int app_id) {
		return student_dao.get_student(app_id);
	}

	@Override
	public List<Programs_scheduled> get_program_name(int app_id) {
		return student_dao.get_program_name(app_id);
	}

	@Override
	public List<user> get_student_id(String user_name) {
		return student_dao.get_student_id(user_name);
	}

}
