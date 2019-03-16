package com.laxman.project.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="application")
public class Application {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="application_id")
	private int application_id;
	
	@Column(name="full_name")
	private String full_name;
	
	@Column(name="user_id")
	private int user_id;

	@Column(name="date_of_birth")
	private Date date_of_birth;
	
	@Column(name="highest_qualification")
	private String highest_qualification;
	
	@Column(name="marks_obtained")
	private int marks_obtained;
	
	@Column(name="goals")
	private String goals;
	
	@Column(name="email_id")
	private String email_id;
	
	@Column(name="schedule_program_id")
	private int schedule_program_id;
	
	@Column(name="status")
	private String status;
	
	@Column(name="date_of_interview")
	private String date_of_interview;

	public int getApplication_id() {
		return application_id;
	}

	public void setApplication_id(int application_id) {
		this.application_id = application_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getHighest_qualification() {
		return highest_qualification;
	}

	public void setHighest_qualification(String highest_qualification) {
		this.highest_qualification = highest_qualification;
	}

	public int getMarks_obtained() {
		return marks_obtained;
	}

	public void setMarks_obtained(int marks_obtained) {
		this.marks_obtained = marks_obtained;
	}

	public String getGoals() {
		return goals;
	}

	public void setGoals(String goals) {
		this.goals = goals;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public int getSchedule_program_id() {
		return schedule_program_id;
	}

	public void setSchedule_program_id(int schedule_program_id) {
		this.schedule_program_id = schedule_program_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate_of_interview() {
		return date_of_interview;
	}

	public void setDate_of_interview(String date_of_interview) {
		this.date_of_interview = date_of_interview;
	}

	@Override
	public String toString() {
		return "Application [application_id=" + application_id + ", full_name=" + full_name + ", user_id=" + user_id
				+ ", date_of_birth=" + date_of_birth + ", highest_qualification=" + highest_qualification
				+ ", marks_obtained=" + marks_obtained + ", goals=" + goals + ", email_id=" + email_id
				+ ", schedule_program_id=" + schedule_program_id + ", status=" + status + ", date_of_interview="
				+ date_of_interview + "]";
	}
	
}
