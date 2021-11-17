package com.example.metier;

import java.util.List;

import com.example.entities.Role;
import com.example.entities.User;
import com.example.entities.UserRole;

public interface InterUserRole {
	public UserRole getOneURole(long idURole);
	public List<UserRole> getUserRole();
	public void deleteUserRole(long idURole);
	public UserRole AddUserRole(UserRole Urole);
	public UserRole EditUserRole(long idURole,UserRole userRole);
}
