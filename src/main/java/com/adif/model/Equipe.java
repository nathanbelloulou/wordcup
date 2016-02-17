package com.adif.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;




@Entity
@NamedQueries({
@NamedQuery(name = "findAllEquipes", query = "select u from Equipe u "),
@NamedQuery(name = "findByName", query = "select u from Equipe u where u.libelle=:libelle ")})
public class Equipe implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String libelle;
	
	private Groupe groupe;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	private String lienImage;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getLienImage() {
		return lienImage;
	}

	public void setLienImage(String lienImage) {
		this.lienImage = lienImage;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

}
