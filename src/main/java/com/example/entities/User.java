package com.example.entities;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.JoinTable;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToMany;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_user",discriminatorType=DiscriminatorType.STRING,length=15)
public class User implements Serializable{
	@Id
	@GeneratedValue
	private Long idUser;
	private String Nom;
	private String Prenom;
	private String Email;
	private String Adress;
	private int Cin;
	private int tel;
	private String photo;
	private String Competance;
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Interview>interview;
	
	@ManyToMany(cascade = CascadeType.ALL , fetch =FetchType.EAGER)
    @JoinTable(name="users_roles" , joinColumns = @JoinColumn(name="idUser") , inverseJoinColumns=@JoinColumn(name="idRole"))
	@JsonIgnore
	private Set<Role> roles = new HashSet<>();
	
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "cv_id")
	 @JsonIgnore
	 private Cv pdfcv;

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(Long idUser, String nom, String prenom, String email, String adress, int cin,
			 int tel, String photo, String competance,Cv pdfcv) {
		super();
		this.idUser = idUser;
		this.Nom = nom;
		this.Prenom = prenom;
		this.Email = email;
		this.Adress = adress;
		this.Cin = cin;
		this.tel = tel;
		this.photo = photo;
		this.Competance = competance;
		this.pdfcv = pdfcv;
	}


	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}

	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public int getCin() {
		return Cin;
	}
	public void setCin(int cin) {
		Cin = cin;
	}
	
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getCompetance() {
		return Competance;
	}
	public void setCompetance(String competance) {
		Competance = competance;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public Set<Interview> getInterview() {
		return interview;
	}
	public void setInterview(Set<Interview> interview) {
		this.interview = interview;
	}
	public Cv getPdfcv() {
		return pdfcv;
	}
	public void setPdfcv(Cv pdfcv) {
		this.pdfcv = pdfcv;
	}


	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Email=" + Email + ", Adress="
				+ Adress + ", Cin=" + Cin + ", tel=" + tel + ", photo=" + photo + ", Competance=" + Competance
				+ ", interview=" + interview + ", roles=" + roles + ", pdfcv=" + pdfcv + "]";
	}
	
}
