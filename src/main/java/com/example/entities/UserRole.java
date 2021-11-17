package com.example.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserRole {
	@Id
	@GeneratedValue
	private Long idURole;

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRole(Long idURole) {
		super();
		this.idURole = idURole;
	}

	public Long getIdURole() {
		return idURole;
	}

	public void setIdURole(Long idURole) {
		this.idURole = idURole;
	}
	
	
}
