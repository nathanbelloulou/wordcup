package com.adif.service;

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.transaction.annotation.Transactional;
import com.adif.model.Utilisateur;

@Named
@Transactional(readOnly = true)
public class UtilisateurService  {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;

	@Transactional(readOnly = false)
	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		em.persist(utilisateur);
		em.refresh(utilisateur);
		return utilisateur;
	}
	@Transactional(readOnly = false)
	public void updateUtilisateur(Utilisateur utilisateur) {
		em.merge(utilisateur);
	}

	@Transactional(readOnly = false)
	public void deleteUtilisateur(Utilisateur utilisateur) {
		em.remove(em.contains(utilisateur) ? utilisateur : em.merge(utilisateur));
	}

	public Utilisateur getUtilisateurById(int id) {
		return em.find(Utilisateur.class, id);
	}
	public Utilisateur getUtilisateurByIdentifiant(String identifiant) {
		return (Utilisateur) em.createNamedQuery("UtilisateurByIdentifiant").setParameter("identifiant", identifiant).getSingleResult();

	}

	@SuppressWarnings("unchecked")
	public List<Utilisateur> findAll() {
		List<Utilisateur> utilisateurs =em.createNamedQuery("findAll").getResultList();
		em.flush();
		return utilisateurs;
	}
	@SuppressWarnings("unchecked")
	public List<Utilisateur> findAllUtilisateurs() {
		List<Utilisateur> utilisateurs =em.createNamedQuery("findAllUtilisateurs").getResultList();
		em.flush();
		return utilisateurs;
	}

}
