package com.adif.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Score implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int butEquipe1;
	private int butEquipe2;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getButEquipe1() {
		return butEquipe1;
	}

	public void setButEquipe1(int butEquipe1) {
		this.butEquipe1 = butEquipe1;
	}

	public int getButEquipe2() {
		return butEquipe2;
	}

	public void setButEquipe2(int butEquipe2) {
		this.butEquipe2 = butEquipe2;
	}

}
