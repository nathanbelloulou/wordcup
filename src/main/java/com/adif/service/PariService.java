package com.adif.service;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.adif.model.Matchs;
import com.adif.model.Pari;
import com.adif.model.Score;
import com.adif.model.Utilisateur;

@Named
@Transactional(readOnly = true)
public class PariService  {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;

	@Transactional(readOnly = false)
	public void addPari(Pari pari) {
		em.persist(pari);


	}
	@Transactional(readOnly = false)
	public void updatePari(Pari pari) {
		em.merge(pari);

	}

	@Transactional(readOnly = false)
	public void deletePari(Pari pari) {
		em.remove(em.contains(pari) ? pari : em.merge(pari));
	}

	public Pari getPariById(int id) {
		return em.find(Pari.class, id);
	}


	@SuppressWarnings("unchecked")
	public List<Pari> findAllPari() {
		List<Pari> paris =em.createNamedQuery("findAllPari").getResultList();
		return paris;
	}

	@SuppressWarnings("unchecked")
	public List<Pari> findAllPariUtilisateur(Utilisateur utilisateur) {
		em.clear();
		try{
			Query query =em.createNamedQuery("findAllPariUtilisateur");
			query.setParameter("utilisateur", utilisateur);
			return query.getResultList();

		} catch(NoResultException e) {
			return null;
		}

	}
	@SuppressWarnings("unchecked")
	public List<Pari> findLastPariUtilisateur(Utilisateur utilisateur) {
		em.clear();
		try{
			Query query =em.createNamedQuery("findLastPariUtilisateur");
			query.setParameter("utilisateur", utilisateur);
			return query.getResultList();

		} catch(NoResultException e) {
			return null;
		}

	}
	public void ouvrirPariMatch(List<Utilisateur> asList ,List<Matchs> matchs) {

		for (Matchs match : matchs) {
			Pari pari= null;
			Score score = null;	

			for (Utilisateur utilisateur : asList) {
				score = new Score();
				score.setButEquipe1(0);
				score.setButEquipe2(0);
				pari=new Pari();
				pari.setMatchs(match);
				pari.setScore(score);
				pari.setUtilisateur(utilisateur);
				pari.setPris(false);
				addPari(pari);

			}
		}	

	}
	public void ouvrirPariUtilisateur(Utilisateur utilisateur, List<Matchs> matchs) {
		Pari pari= null;
		for (Matchs match : matchs) {
			pari=new Pari();
			pari.setMatchs(match);
			pari.setUtilisateur(utilisateur);
			addPari(pari);
			em.detach(pari);
		}

	}
	@SuppressWarnings("unchecked")
	public void calculPoint(Matchs matchs) {
		Query query =em.createNamedQuery("findPariForMatch");
		query.setParameter("matchId", matchs.getId());
		List<Pari> paris=query.getResultList();
		for (Pari pari : paris) {
			pari.setPointDiff(calculDiff(pari.getScore(),matchs.getScore()));
			pari.setPointGagnant(calculGagnant(pari.getScore(),matchs.getScore()));
			pari.setScoreExact(calculcoreExact(pari.getScore(),matchs.getScore()));
			pari.setMatchs(matchs);
			updatePari(pari);
		}
	}
		public void calculPoint(Utilisateur utilisateur) {

			List<Pari> paris=findAllPariUtilisateur(utilisateur);
			for (Pari pari : paris) {
				if (pari.getMatchs().getScore()!=null) {
					
				
				pari.setPointDiff(calculDiff(pari.getScore(),pari.getMatchs().getScore()));
				pari.setPointGagnant(calculGagnant(pari.getScore(),pari.getMatchs().getScore()));
				pari.setScoreExact(calculcoreExact(pari.getScore(),pari.getMatchs().getScore()));
			
				updatePari(pari);
			}
			}
	}
	public int calculcoreExact(Score score, Score score2) {
		if(score.getButEquipe1()==score2.getButEquipe1()&&score.getButEquipe2()==score2.getButEquipe2()){
			return 1;
		}
		return 0;
	}
	public int calculGagnant(Score score, Score score2) {
		if(((score.getButEquipe1() -score.getButEquipe2()>0)&&(score2.getButEquipe1()-score2.getButEquipe2()>0))
				||((score.getButEquipe1() -score.getButEquipe2()<0)&&(score2.getButEquipe1()-score2.getButEquipe2()<0))
				||((score.getButEquipe1() -score.getButEquipe2()==0)&&(score2.getButEquipe1()-score2.getButEquipe2()==0))){
			return 2;
		}
		return 0;
	}
	public int calculDiff(Score score, Score score2) {
		if((score.getButEquipe1()-score2.getButEquipe1())==(score.getButEquipe2()-score2.getButEquipe2())){
			return 1;
		}
		return 0;
	}
	public Pari findPariUtilisateurAndOrdre(
			Utilisateur utilisateur, int nMatch) {
		Query query =em.createNamedQuery("findPariUtilisateurAndOrdre");
		query.setParameter("matchOrdre", nMatch);
		query.setParameter("utilisateurId", utilisateur.getId());
		return (Pari) query.getSingleResult();
	}




}
