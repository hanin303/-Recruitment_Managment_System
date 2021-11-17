package com.example.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cv implements Serializable{
	
	@Id 
	@GeneratedValue
	private long idCV;
	private String pdf;
	
	
	public Cv() {
		super();
	// TODO Auto-generated constructor stub
	}


	public Cv(long idCV, String pdf) {
		super();
		this.idCV = idCV;
		this.pdf = pdf;
	}


	public long getIdCV() {
		return idCV;
	}


	public void setIdCV(long idCV) {
		this.idCV = idCV;
	}


	public String getPdf() {
		return pdf;
	}


	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	
	
	
	
}
