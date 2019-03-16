package com.laxman.project.service;

import java.util.List;

import com.laxman.project.entity.Application;
import com.laxman.project.entity.Programs_Offered;
import com.laxman.project.entity.Programs_scheduled;
import com.laxman.project.entity.User;

public interface student_service {
	public List<Programs_scheduled> get_programs_scheduled_student_not_applied(int id);

	public void save_new_student(User student);

	public void save_application(Application app);

	public List<Programs_scheduled> get_programs_scheduled_student_interview_approval_waiting(int id);

	public List<Programs_scheduled> get_programs_scheduled_student_confirmation_waiting(int id);

	public List<Programs_scheduled> get_programs_scheduled_student_confirmed(int id);

	public List<Programs_scheduled> get_programs_scheduled_student_rejected(int id);
}
