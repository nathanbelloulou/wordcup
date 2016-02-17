package com.adif.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({ 
		@NamedQuery(name = "UtilisateurByIdentifiant", query = "select u from Utilisateur u where u.identifiant = :identifiant"),
		@NamedQuery(name = "findAll", query = "select u from Utilisateur u "), 
		@NamedQuery(name = "findAllUtilisateurs", query = "select u from Utilisateur u where u.abilitationAdministrateur=false")})
public class Utilisateur implements Serializable{

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", identifiant=" + identifiant + ", motpasse=" + motpasse
				+ ", email=" + email + "]";
	}

	private static final long serialVersionUID = 1L;
	
	
	private int id;
	private String nom;
	private String prenom;
	private String identifiant;
	private String motpasse;
	private String email;
	private boolean abilitationAdministrateur;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}	
	
	
	public String getMotpasse() {
		return motpasse;
	}

	public void setMotpasse(String password) {
		this.motpasse = password;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public boolean isAbilitationAdministrateur() {
		return abilitationAdministrateur;
	}

	public void setAbilitationAdministrateur(boolean abilitationAdministrateur) {
		this.abilitationAdministrateur = abilitationAdministrateur;
	}
	
}
