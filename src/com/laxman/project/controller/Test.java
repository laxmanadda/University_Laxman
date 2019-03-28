package com.laxman.project.controller;

import java.util.List;

import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.*;
import org.springframework.stereotype.Component;

import com.laxman.project.entity.Application;
import com.laxman.project.entity.Programs_scheduled;
import com.laxman.project.entity.user;
import com.laxman.project.service.student_service;

@Component
public class Test {
	
	@Autowired
	private student_service stud_service;
	
	String sender="Lakshman.university@gmail.com";
	String subject="";
	String msg="";
	ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
	MailMail m= (MailMail) context.getBean("mailMail");
	
	public void send_mail(String situation) {
		if(situation.equalsIgnoreCase("start_process")){
			subject="Application Process";
			msg="The application process for Lakshman's University has started";
			String[] receivers =stud_service.get_students_email();
			receivers[receivers.length]="mac@gmail.com";
			m.sendMail(sender, receivers, subject, msg);
		
		}else{
			if(situation.equalsIgnoreCase("program_offered")) {
				subject="New Program Offered has been added";
				msg="New Program Offered Has been added in the Lakshman's University Curriculam";
			}else {
				subject="New Scheduled Program has been added";
				msg="New Program Scheduled Has been added in the Lakshman's University Curriculam";
			}
			String[] receivers =stud_service.get_students_email();
			receivers[receivers.length]="mac@gmail.com";
			m.sendMail(sender, receivers, subject, msg);
		}
	}
	
	public void applied_mail(Application app) {
		subject="Your Application has been saved succesfully";
		List<Programs_scheduled> program_scheduled_list=stud_service.get_program_name(app.getApplication_id());
		String program_name=program_scheduled_list.get(0).getProgramName();
		msg="Your application for the program "+program_name+" has been sucessfully saved and sent for review.Just sit back and relax";
		String[] receivers = {app.getEmail_id()};
		receivers[receivers.length]="mac@gmail.com";
		m.sendMail(sender, receivers, subject, msg);
	}
	public void approved_mail(int app_id) {
			subject="Approved for next round";
			List<Application> app=stud_service.get_student(app_id);
			List<Programs_scheduled> program_scheduled_list=stud_service.get_program_name(app_id);
			String program_name=program_scheduled_list.get(0).getProgramName();
			
			msg="Your application for the program "+program_name+ " has ben approved for interview round which will be on "+app.get(0).getDate_of_interview();
			
			String[] receivers = {app.get(0).getEmail_id()};
			m.sendMail(sender, receivers, subject, msg);
	}
	
	public void rejection_mail(int app_id) {
		subject="Application Rejected";
		List<Application> app=stud_service.get_student(app_id);
		List<Programs_scheduled> program_scheduled_list=stud_service.get_program_name(app_id);
		String program_name=program_scheduled_list.get(0).getProgramName();
		
		msg="Your application for the program "+program_name+ " has been rejected";
		
		String[] receivers = {app.get(0).getEmail_id()};
		m.sendMail(sender, receivers, subject, msg);
}
	
	public void confirmation_mail(int app_id) {
			subject="Application Approved";
			List<Application> app=stud_service.get_student(app_id);
			String student_name=app.get(0).getFull_name();
			
			List<Programs_scheduled> program_scheduled_list=stud_service.get_program_name(app_id);
			String program_name=program_scheduled_list.get(0).getProgramName();
			msg="Congratulations "+student_name +" Your application for program "+ program_name +" has been approved";
			
			String[] receivers= {app.get(0).getEmail_id()};
			m.sendMail(sender, receivers, subject, msg);
	}
		
}
