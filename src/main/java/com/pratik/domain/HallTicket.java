package com.pratik.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="HALLTicket_OTO")
public class HallTicket {
	@Id
	@GenericGenerator(name="foreignGen",
						strategy="foreign",
						parameters=@Parameter(name="property",value="stud"))
	@GeneratedValue(generator="foreignGen")
	private int ticketId;
	private String exam;
	
	@OneToOne(targetEntity=Student.class,
			cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="ticketId",referencedColumnName="studId")
	
	private Student stud;

	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getExam() {
		return exam;
	}
	public void setExam(String exam) {
		this.exam = exam;
	}
	public Student getStud() {
		return stud;
	}
	public void setStud(Student stud) {
		this.stud = stud;
	}
	@Override
	public String toString() {
		return "HallTicket [ticketId=" + ticketId + ", exam=" + exam +"]";
	}

	
	
	
}
