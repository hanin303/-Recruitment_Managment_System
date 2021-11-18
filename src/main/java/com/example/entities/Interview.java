package com.example.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="INTERVIEW")
public class Interview implements Serializable {
	@Id @GeneratedValue
	private Long id_Interview;
	private Date interviewDate;
	private String interviewType;
	private String location;
	
	@ManyToOne
	@JoinColumn(name="IdUser")
	private User user ;
	
	public Interview () {}
	
	public Interview(Long id_Interview, Date interviewDate, String interviewType, String location) {
		super();
		this.id_Interview = id_Interview;
		this.interviewDate = interviewDate;
		this.interviewType = interviewType;
		this.location = location;
	}
	
	
	public Long getId_Interview() {
		return id_Interview;
	}
	public void setId_Interview(Long id_Interview) {
		this.id_Interview = id_Interview;
	}
	public Date getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}
	public String getInterviewType() {
		return interviewType;
	}
	public void setInterviewType(String interviewType) {
		this.interviewType = interviewType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}