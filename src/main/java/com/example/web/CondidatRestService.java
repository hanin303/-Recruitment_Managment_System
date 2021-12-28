package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.CVRepository;
import com.example.entities.Condidats;
import com.example.metier.InterCondidatMetier;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CondidatRestService {
	
	@Autowired
	private InterCondidatMetier condMetier;
	
	@Autowired
	CVRepository cvRep;
	
	@RequestMapping(value="/condidats",method = RequestMethod.GET)
	public List<Condidats> getCondidats(){
		return condMetier.getCondidat();
	}
	
	
	@RequestMapping(value="/condidats/{iduser}",method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('RECRUTEUR') or hasAuthority('INTERVIEWER') ")
    public Condidats getCondidats(@PathVariable long iduser) {
		return condMetier.getOneCondidat(iduser);
	}
	
	
	
	@RequestMapping(value="/condidats/{iduser}",method = RequestMethod.DELETE)
	@ResponseBody
	@PreAuthorize("hasAuthority('RECRUTEUR') or hasAuthority('ADMIN') ")
	public void deleteUser(@PathVariable long iduser) {
			condMetier.deleteCondidat(iduser);
	}
	
	@RequestMapping(value="/condidats/{idOffre}",method = RequestMethod.POST)
	public void AddCondidat(@RequestBody Condidats user,@PathVariable long idOffre){
		        condMetier.AddCondidat(user,idOffre);
	}
	

	
	@RequestMapping(value="/condidats/{iduser}",method = RequestMethod.PUT)
	public ResponseEntity<Condidats> EditCondidat(@PathVariable long iduser, @RequestBody Condidats user){
		 return ResponseEntity.ok(condMetier.EditCondidat(iduser, user));
    }


}
