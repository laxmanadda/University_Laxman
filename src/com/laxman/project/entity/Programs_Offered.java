package com.laxman.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="programs_offered")
public class Programs_Offered {
	
	@Id
	@Column(name="ProgramName", nullable=false)
	private String ProgramName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="applicant_eligibility")
	private String applicant_eligibility;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="degree_certificate_offered")
	private String degree_certificate_offered;

	public String getProgramName() {
		return ProgramName;
	}

	public void setProgramName(String programName) {
		ProgramName = programName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApplicant_eligibility() {
		return applicant_eligibility;
	}

	public void setApplicant_eligibility(String applicant_eligibility) {
		this.applicant_eligibility = applicant_eligibility;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDegree_certificate_offered() {
		return degree_certificate_offered;
	}

	public void setDegree_certificate_offered(String degree_certificate_offered) {
		this.degree_certificate_offered = degree_certificate_offered;
	}

	@Override
	public String toString() {
		return "Programs_Offered [ProgramName=" + ProgramName + ", description=" + description
				+ ", applicant_eligibility=" + applicant_eligibility + ", duration=" + duration
				+ ", degree_certificate_offered=" + degree_certificate_offered + "]";
	}
	
}
