package com.laxman.project.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="programs_scheduled")
public class Programs_scheduled {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="schedule_program_id")
	private int scheduled_program_id;
	
	@Column(name="ProgramName")
	private String ProgramName;
	
	@Column(name="location")
	private String location;
	
	@Column(name="start_date")
	private Date start_date;
	
	@Column(name="end_date")
	private Date end_date;
	
	@Column(name="sessions_per_week")
	private int sessions_per_week;
	

	public int getScheduled_program_id() {
		return scheduled_program_id;
	}

	public void setScheduled_program_id(int scheduled_program_id) {
		this.scheduled_program_id = scheduled_program_id;
	}

	public String getProgramName() {
		return ProgramName;
	}

	public void setProgramName(String programName) {
		ProgramName = programName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getSessions_per_week() {
		return sessions_per_week;
	}

	public void setSessions_per_week(int sessions_per_week) {
		this.sessions_per_week = sessions_per_week;
	}

	@Override
	public String toString() {
		return "Programs_scheduled [scheduled_program_id=" + scheduled_program_id + ", ProgramName=" + ProgramName
				+ ", location=" + location + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", sessions_per_week=" + sessions_per_week + "]";
	}
	
	
}
