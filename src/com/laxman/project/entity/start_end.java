package com.laxman.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="start_end")
public class start_end {
	
	@Id
	@Column(name="Start")
	private long Start;
	
	@Column(name="End")
	private long End;

	public long getStart() {
		return Start;
	}

	public void setStart(long start) {
		Start = start;
	}

	public long getEnd() {
		return End;
	}

	public void setEnd(long end) {
		End = end;
	}
	
	
}
