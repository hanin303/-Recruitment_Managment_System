package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.User;
import com.example.entities.UserRole;
import com.example.metier.InterUserMetier;
import com.example.metier.InterUserRole;

@RestController
public class UserRoleRestService {
	@Autowired
	private InterUserRole urMetier;
	


	@RequestMapping(value="/URole",method = RequestMethod.GET)
	public List<UserRole> getURole(){
		return urMetier.getUserRole();
	}
	
	
	@RequestMapping(value="/URole/{idURole}",method = RequestMethod.GET)
    public UserRole getUser(@PathVariable long idURole) {
		return urMetier.getOneURole(idURole);
	}
	
	
	@RequestMapping(value="/URole/{idURole}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteURole(@PathVariable long idURole) {
			urMetier.deleteUserRole(idURole);
	}
	
	@RequestMapping(value="/URole",method = RequestMethod.POST)
	public UserRole AddURole(@RequestBody UserRole ur){
    	return urMetier.AddUserRole(ur);
	}
	
	
	@RequestMapping(value="/URole/{idURole}",method = RequestMethod.PUT)
	public ResponseEntity<UserRole> EditURole(@PathVariable long idURole, @RequestBody UserRole userR){
		 return ResponseEntity.ok(urMetier.EditUserRole(idURole, userR));
    }


}

