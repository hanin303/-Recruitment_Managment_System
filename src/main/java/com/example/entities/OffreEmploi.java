package com.example.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OffreEmploi implements Serializable{
	
	@Id 
	@GeneratedValue
	private long idOffre;
	private String Titre;
	private String Description;
	private int nbPost;
	private Date date;
	
	
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;
	
	public OffreEmploi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OffreEmploi(long idOffre, String titre, String description, int nbPost, Date date) {
		super();
		this.idOffre = idOffre;
		Titre = titre;
		Description = description;
		this.nbPost = nbPost;
		this.date = date;
	}

	public long getIdOffre() {
		return idOffre;
	}

	public void setIdOffre(long idOffre) {
		this.idOffre = idOffre;
	}

	public String getTitre() {
		return Titre;
	}

	public void setTitre(String titre) {
		Titre = titre;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getNbPost() {
		return nbPost;
	}

	public void setNbPost(int nbPost) {
		this.nbPost = nbPost;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
