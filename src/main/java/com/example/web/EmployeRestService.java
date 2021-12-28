package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.EmployeRepository;
import com.example.entities.Employee;
import com.example.service.UserService;


@RestController
public class EmployeRestService {
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired 
	private UserService userService;
	
	
	/*@RequestMapping(value="/employee",method = RequestMethod.GET)
	@GetMapping
	public List<Employee> getEmployees(){
		return employeRepository.findAll();
		}
	
	@RequestMapping(value="/employee/{id}",method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable Integer id) {
		return employeRepository.findById(id).get();
	}
	
	@PostMapping("/employee")
	public Employee AddEmployee(@RequestBody Employee c){
    	return employeRepository.save(c);
	}
	
	@RequestMapping(value="/user/{iduser}",method = RequestMethod.DELETE)
     @ResponseBody
	public void deleteEmployee(@PathVariable Integer iduser) {
			employeRepository.deleteById(iduser);
	}
	
	
	@RequestMapping(value="/employee/{iduser}",method = RequestMethod.PUT)
	public Employee EditUser(@PathVariable Integer iduser, @RequestBody Employee user){
		return employeRepository.save(user);
    }*/
	
}


