package com.example.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("condidats")
public class Condidats extends User{

	
	public Condidats() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Condidats(Long idUser, String nom, String prenom, String email, String adress, int cin,
			 int tel, String photo, String competance,Cv pdfcv) {
		super(idUser,nom,prenom,email,adress,cin,tel,photo, competance,pdfcv);
		// TODO Auto-generated constructor stub
	}
	
}
