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

import com.example.entities.Cv;
import com.example.metier.InterCVMetier;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CVRestService {
	
	@Autowired
	private InterCVMetier CvMetier;
	
	@RequestMapping(value="/cv",method = RequestMethod.GET)
	public List<Cv> getCv(){
		return CvMetier.getCv();
	}
	
	@RequestMapping(value="/cv/{code}",method = RequestMethod.GET)
    public Cv getCv(@PathVariable long code) {
		return CvMetier.getOneCv(code);
	}
	
	
	@RequestMapping(value="/cv/{code}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCv(@PathVariable long code) {
			CvMetier.deleteCv(code);
	}
	
	@RequestMapping(value="/cv",method = RequestMethod.POST)
	public Cv AddCv(@RequestBody Cv CvAdd){
    	return CvMetier.AddCv(CvAdd);
	}
	
	
	@RequestMapping(value="/cv/{code}",method = RequestMethod.PUT)
	public ResponseEntity<Cv> EditCv(@PathVariable long code, @RequestBody Cv CvModif){
		 return ResponseEntity.ok(CvMetier.EditCv(code, CvModif));
    }

}
