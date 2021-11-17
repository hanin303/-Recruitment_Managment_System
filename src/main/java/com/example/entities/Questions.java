package com.example.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Questions implements Serializable{
	@Id @GeneratedValue
	private Long id_Question;
	private String Question;
	public Questions(Long id_Question, String question) {
		super();
		this.id_Question = id_Question;
		Question = question;
	}
	public Questions () {}
	public Long getId_Question() {
		return id_Question;
	}
	public void setId_Question(Long id_Question) {
		this.id_Question = id_Question;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	
}
