package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {
	@Id
	@GeneratedValue
	private Long idRole;
	private String Role_type;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Long idRole, String role_type) {
		super();
		this.idRole = idRole;
		Role_type = role_type;
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getRole_type() {
		return Role_type;
	}

	public void setRole_type(String role_type) {
		Role_type = role_type;
	}
	
}
