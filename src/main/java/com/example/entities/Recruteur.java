package com.example.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="recruteur")
public class Recruteur extends User{
	private String Pwd;
	private Date DateEmbauche;
	
	
	public Recruteur() {
		super();	
	}


	public Recruteur(Long idUser, String nom, String prenom, String email, String adress, int cin,
			 int tel, String photo, String competance,Cv pdfcv,String pwd, Date dateEmbauche) {
		super(idUser,nom,prenom,email,adress,cin,tel,photo, competance,pdfcv);
		Pwd = pwd;
		DateEmbauche = dateEmbauche;
	}


	public String getPwd() {
		return Pwd;
	}


	public void setPwd(String pwd) {
		Pwd = pwd;
	}


	public Date getDateEmbauche() {
		return DateEmbauche;
	}


	public void setDateEmbauche(Date dateEmbauche) {
		DateEmbauche = dateEmbauche;
	}
	
	

	
}
