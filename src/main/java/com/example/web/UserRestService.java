package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserRepository;
import com.example.entities.Condidats;
import com.example.entities.Cv;
import com.example.entities.User;
import com.example.metier.InterUserMetier;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserRestService {
	@Autowired
	private InterUserMetier userMetier;
	
	@RequestMapping(value="/user",method = RequestMethod.GET)
	public List<User> getUser(){
		return userMetier.getUser();
	}
	
		
	@RequestMapping(value="/user/{iduser}",method = RequestMethod.GET)
    public User getUser(@PathVariable long iduser) {
		return userMetier.getOneUser(iduser);
	}
	
	
	@RequestMapping(value="/user/{iduser}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUser(@PathVariable long iduser) {
			userMetier.deleteUser(iduser);
	}
	
	@RequestMapping(value="/user",method = RequestMethod.POST)
	public User AddUser(@RequestBody User user){
    	return userMetier.AddUser(user);
	}
	
	@RequestMapping(value="/user/{iduser}",method = RequestMethod.PUT)
	public ResponseEntity<User> EditUser(@PathVariable long iduser, @RequestBody User user){
		 return ResponseEntity.ok(userMetier.EditUser(iduser, user));
    }

	
}
