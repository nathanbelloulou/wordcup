package com.adif.service;


import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.adif.model.Groupe;

@Named
@Transactional(readOnly = true)
public class GroupeService  {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;

	@Transactional(readOnly = false)
	public void addGroupe(Groupe groupe) {
		em.persist(groupe);

	}
	@Transactional(readOnly = false)
	public void updateGroupe(Groupe groupe) {
		em.merge(groupe);

	}

	@Transactional(readOnly = false)
	public void deleteGroupe(Groupe groupe) {
		em.remove(em.contains(groupe) ? groupe : em.merge(groupe));
	}

	public Groupe getGroupeById(int id) {
		return em.find(Groupe.class, id);
	}
	
	public Groupe findByNameGroupe(String libelle) {
		try{
			Query query =em.createNamedQuery("findByNameGroupe");
			query.setParameter("libelle", libelle);
			return (Groupe) query.getSingleResult();

		} catch(NoResultException e) {
	}
		return null;
	
	}

}
