package com.pratik.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_OTO")
public class Student {

	@Id
	private int studId;
	private String studName;
	
	@OneToOne(targetEntity=HallTicket.class,
			cascade=CascadeType.ALL,
			mappedBy="stud")
	
	private HallTicket hall;
	
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public HallTicket getHall() {
		return hall;
	}
	public void setHall(HallTicket hall) {
		this.hall = hall;
	}
	
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName +  "]";
	}
	
	
	
	
}
