package com.adif.service;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.transaction.annotation.Transactional;

import com.adif.model.Matchs;

@Named
@Transactional(readOnly = true)
public class MatchService  {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	@Transactional(readOnly = false)
	public void addMatch(Matchs match) {
			em.persist(match);
	}
	
	@Transactional(readOnly = false)
	public void updateMatch(Matchs match) {
				em.merge(match);
	}
	
	@Transactional(readOnly = false)
	public void deleteMatch(Matchs match) {
		em.remove(em.contains(match) ? match : em.merge(match));
	}

	public Matchs getMatchById(int id) {
		return em.find(Matchs.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Matchs> findAll() {
		List<Matchs> matchs =em.createNamedQuery("FindAllMatchs").getResultList();
		em.flush();
		return matchs;
	}
	
	
}
