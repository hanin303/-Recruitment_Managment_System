package com.example.entities;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="admin")
public class Admin extends User{
	private String Pwd;
	private Date DateEmbauche;
	
	
	
	public Admin() {
		super();
		
	}


	public Admin(Long idUser, String nom, String prenom, String email, String adress, int cin,
			 int tel, String photo,Cv pdfcv,String pwd, Date dateEmbauche,String LienG,String LienF,String LienI,String LienL) {
		super(idUser,nom,prenom,email,adress,cin,tel,photo,pdfcv,LienG,LienF,LienI,LienL);
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
