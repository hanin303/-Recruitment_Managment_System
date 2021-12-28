package com.example.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="recruteur")
public class Recruteur extends User{
	private Date DateEmbauche;
	
	
	public Recruteur() {
		super();	
	}


	public Recruteur(Long idUser, String nom, String prenom, String email, String adress, int cin,
			 int tel, String photo, String competance,Cv pdfcv, Date dateEmbauche) {
		super(idUser,nom,prenom,email,adress,cin,tel,photo, competance,pdfcv);
		
		DateEmbauche = dateEmbauche;
	}


	public Date getDateEmbauche() {
		return DateEmbauche;
	}


	public void setDateEmbauche(Date dateEmbauche) {
		DateEmbauche = dateEmbauche;
	}


	@Override
	public String toString() {
		return "Recruteur [DateEmbauche=" + DateEmbauche + "]";
	}

	
	
}
