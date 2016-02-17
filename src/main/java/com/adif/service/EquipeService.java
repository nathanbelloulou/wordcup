package com.adif.service;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.adif.model.Equipe;

@Named
@Transactional(readOnly = true)
public class EquipeService  {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	@Transactional(readOnly = false)
	public void addEquipe(Equipe activite) {
			em.persist(activite);
	}
	
	@Transactional(readOnly = false)
	public void updateEquipe(Equipe equipe) {
			em.merge(equipe);
	}
	
	@Transactional(readOnly = false)
	public void deleteEquipe(Equipe activite) {
		em.remove(em.contains(activite) ? activite : em.merge(activite));
	}

	public Equipe getEquipeById(int id) {
		return em.find(Equipe.class, id);
	}
	

	@SuppressWarnings("unchecked")
	public List<Equipe> findAll() {
		List<Equipe> activites =em.createNamedQuery("findAllEquipes").getResultList();
		return activites;
	}

	public Equipe findByName(String libelle) {
		try{
			Query query =em.createNamedQuery("findByName");
			query.setParameter("libelle", libelle);
			Equipe equipe= (Equipe) query.getSingleResult();
			if(equipe!=null){
			return equipe;
			}else{
				equipe= new Equipe();
				equipe.setLibelle(libelle);
				addEquipe(equipe);
				return  equipe;
			}

		} catch(NoResultException e) {
	}
		return null;
	
	}
}
