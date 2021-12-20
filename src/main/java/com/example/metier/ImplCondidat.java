package com.example.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dao.CondidatRepository;
import com.example.dao.UserRepository;
import com.example.entities.Condidats;
import com.example.entities.User;

@Service
public class ImplCondidat implements InterCondidatMetier {
	@Autowired
	private CondidatRepository CondRep;

	@Override
	public Condidats getOneCondidat(long iduser) {
		Optional<Condidats> condidats = CondRep.findById(iduser);
		if (condidats.isPresent()) { 
			return condidats.get();
		}else throw new RuntimeException("Condidat introuvable !! ");
	}

	@Override
	public List<Condidats> getCondidat() {
		return CondRep.findAll();
	}

	@Override
	public void deleteCondidat(long idUser) {
		Optional<Condidats> condidats = CondRep.findById(idUser);
		if (condidats.isPresent()) { 
			Condidats condidat = condidats.get();
			CondRep.delete(condidat);
		}else throw new RuntimeException("Condidat introuvable !! ");	
	}

	@Override
	public Condidats AddCondidat(Condidats user) {
		Optional<Condidats> c =  CondRep.findById(user.getIdUser());
		if (c.isPresent() == false) { 
			return CondRep.save(user);
		}else throw new RuntimeException("cet utilisateur déjà existe");
	}

	@Override
	public Condidats EditCondidat(long id, Condidats condidat) {
		Condidats c = CondRep.findById(id).orElseThrow(()->new ResourceNotFoundException("Ce condidat n'existe pas"));
		
		c.setIdUser(condidat.getIdUser());
		c.setNom(condidat.getNom());
		c.setPrenom(condidat.getPrenom());
		c.setAdress(condidat.getAdress());
		c.setCin(condidat.getCin());
		c.setEmail(condidat.getEmail());
		c.setCompetance(condidat.getCompetance());
		c.setTel(condidat.getTel());
		 CondRep.save(c);
		
		 return c;
	}

	
}
