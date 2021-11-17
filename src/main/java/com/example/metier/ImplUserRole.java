package com.example.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dao.UserRepository;
import com.example.dao.UserRoleRepository;
import com.example.entities.User;
import com.example.entities.UserRole;
@Service
public class ImplUserRole implements InterUserRole {
	@Autowired
	private UserRoleRepository uRoleRepository;

	@Override
	public UserRole getOneURole(long idURole) {
		Optional<UserRole> uRole= uRoleRepository.findById(idURole);
		if (uRole.isPresent()) { 
			return uRole.get();
		}else throw new RuntimeException("UserRole introuvable !! ");
	}

	@Override
	public List<UserRole> getUserRole() {
		return uRoleRepository.findAll();
	}

	@Override
	public void deleteUserRole(long idURole) {
		Optional<UserRole> uRole = uRoleRepository.findById(idURole);
		if (uRole.isPresent()) { 
			uRoleRepository.deleteById(idURole);
	    }else throw new RuntimeException("UserRole introuvable on ne peut pas le supprimer !");
	}
	@Override
	public UserRole AddUserRole(UserRole Urole) {
		Optional<UserRole> u =  uRoleRepository.findById(Urole.getIdURole());
		if (u.isPresent() == false) { 
			return uRoleRepository.save(Urole);
		}else throw new RuntimeException("UserRole déjà existe");
	}

	@Override
	public UserRole EditUserRole(long idURole, UserRole userRole) {
		UserRole u = uRoleRepository.findById(idURole).orElseThrow(()->new ResourceNotFoundException("UserRole n'existe pas"));
		u.setIdURole(userRole.getIdURole());
		uRoleRepository.save(u);
			
	  	return u;
	}

	
	
}
