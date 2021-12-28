package com.example.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.dao.CVRepository;
import com.example.dao.CondidatRepository;
import com.example.dao.OffreEmploiRepository;
import com.example.entities.Condidats;
import com.example.entities.Cv;
import com.example.entities.Interview;
import com.example.entities.OffreEmploi;
import com.example.metier.InterCondidatMetier;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CondidatRestService {
	

	@Autowired
	OffreEmploiRepository offerRep;
	
	@Autowired
	private CondidatRepository CondRep;
	
	@Autowired
	private InterCondidatMetier condMetier;
	
	@Autowired
	CVRepository cvRep;
	
	@Value("${logging.file.path}")
	String FILE_DIRECTORY;
	
	@RequestMapping(value="/condidats",method = RequestMethod.GET)
	public List<Condidats> getCondidats(){
		return condMetier.getCondidat();
	}
	
	
	@RequestMapping(value="/condidats/{iduser}",method = RequestMethod.GET)
    public Condidats getCondidats(@PathVariable long iduser) {
		return condMetier.getOneCondidat(iduser);
	}
	
	
	
	@RequestMapping(value="/condidats/{iduser}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUser(@PathVariable long iduser) {
			condMetier.deleteCondidat(iduser);
	}
	
	@RequestMapping(value="/condidats/{idOffre}",method = RequestMethod.POST)
	public void AddCondidat(@RequestBody Condidats user,@PathVariable long idOffre){
		
		boolean test = false;
		Condidats condAj = new Condidats();
		List<Condidats> ListCondidats = this.getCondidats();
		for (int i = 0; i < ListCondidats.size(); i++) {
			if(ListCondidats.get(i).getCin() == user.getCin()) {
		    	   test = true;
		    	   condAj = ListCondidats.get(i);
		    	   System.out.println(condAj);
		    	   break;
		      }else {
		    	  test = false;
		      }  
		    }
		
		   	if (test == false) { 
				OffreEmploi offer = offerRep.findById(idOffre).get();
			  	Interview interview = new Interview();
				interview.setUser(user);
				interview.setOffre(offer);
				Set<Interview> ListInterv =new HashSet<Interview>() ;
				ListInterv.add(interview);
				user.setInterview(ListInterv);
				CondRep.save(user);
    	   }else if (test == true) {
    		    OffreEmploi offer = offerRep.findById(idOffre).get();
			  	Interview interview = new Interview();
				interview.setUser(condAj);
				interview.setOffre(offer);
				Set<Interview> ListInterv =new HashSet<Interview>() ;
				ListInterv.add(interview);
				condAj.setInterview(ListInterv);
				CondRep.save(condAj);
    	}
		
	}

	@RequestMapping(value="/condidats/{iduser}",method = RequestMethod.PUT)
	public ResponseEntity<Condidats> EditCondidat(@PathVariable long iduser, @RequestBody Condidats user){
		 return ResponseEntity.ok(condMetier.EditCondidat(iduser, user));
    }


}
