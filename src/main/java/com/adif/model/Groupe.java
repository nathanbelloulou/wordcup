package com.adif.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
@Entity
@NamedQuery(name = "findByNameGroupe", query = "select u from Groupe u where u.libelle=:libelle ")
public class Groupe {
	
	private int id;
	
	private char libelle;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getLibelle() {
		return libelle;
	}

	public void setLibelle(char libelle) {
		this.libelle = libelle;
	}
	


	

}
