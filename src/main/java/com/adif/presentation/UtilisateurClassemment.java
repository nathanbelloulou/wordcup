package com.adif.presentation;

import java.io.Serializable;

import com.adif.model.Utilisateur;

public class UtilisateurClassemment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Utilisateur utilisateur;
	private int nbPari;
	private int score;

	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public int getNbPari() {
		return nbPari;
	}

	public void setNbPari(int nbPari) {
		this.nbPari = nbPari;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
