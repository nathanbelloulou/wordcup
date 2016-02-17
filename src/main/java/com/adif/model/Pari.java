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
@NamedQuery(name = "findAllPariUtilisateur", query = "select u from Pari u where u.utilisateur = :utilisateur order by u.matchs.debut")
,@NamedQuery(name ="findLastPariUtilisateur" , query = "select u from Pari u where u.utilisateur = :utilisateur and u.matchs.score is null order by u.matchs.debut")
,@NamedQuery(name = "findPariForMatch", query = "select u from Pari u where u.matchs.id =:matchId")
,@NamedQuery(name = "findPariUtilisateurAndOrdre", query = "select u from Pari u where u.matchs.ordre =:matchOrdre and u.utilisateur.id = :utilisateurId ")
})

public class Pari implements Serializable{

	private static final long serialVersionUID = 1L;
	
	 
	
	private int id;
	
	private Matchs matchs;
	private Score score;
	private Utilisateur utilisateur;
	private int pointDiff;
	private int scoreExact;
	private int pointGagnant;
	private boolean pris;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	@ManyToOne(cascade={CascadeType.ALL})
	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}
	
	@ManyToOne
	public Matchs getMatchs() {
		return matchs;
	}

	public void setMatchs(Matchs matchs) {
		this.matchs = matchs;
	}
	@ManyToOne
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public int getPointDiff() {
		return pointDiff;
	}

	public void setPointDiff(int pointDiff) {
		this.pointDiff = pointDiff;
	}

	public int getScoreExact() {
		return scoreExact;
	}

	public void setScoreExact(int scoreExact) {
		this.scoreExact = scoreExact;
	}

	public int getPointGagnant() {
		return pointGagnant;
	}

	public void setPointGagnant(int pointGagnant) {
		this.pointGagnant = pointGagnant;
	}

	public boolean isPris() {
		return pris;
	}

	public void setPris(boolean pris) {
		this.pris = pris;
	}

}
