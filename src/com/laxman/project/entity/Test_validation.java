package com.laxman.project.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Test_validation {
	String first_name;
	
	@NotNull(message="last_name is required")
	@Size(min=1,message="last_name is required")
	String last_name;

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
}
