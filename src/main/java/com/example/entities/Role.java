package com.example.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Role {
	@Id
	@GeneratedValue
	private Long idRole;
	private String Role_type;
	
	
	@ManyToMany(cascade = CascadeType.ALL , fetch =FetchType.LAZY , mappedBy = "roles" )
	@JsonBackReference
    private Set<User> users = new HashSet<>();
	
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
}