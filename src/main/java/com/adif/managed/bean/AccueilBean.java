package com.adif.managed.bean;



import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.adif.model.Pari;
import com.adif.presentation.UtilisateurClassemment;
import com.adif.service.PariService;
import com.adif.utils.AuthBean;
import com.adif.utils.DateUtil;

@Named
@Scope("session")
public class AccueilBean {

	@Inject
	private PariService pariService;

	@Inject
	private AuthBean authbean;

	


	private List<UtilisateurClassemment> utilisateurClassemments;

	public AuthBean getAuthbean() {
		return authbean;
	}

	public void setAuthbean(AuthBean authbean) {
		this.authbean = authbean;
	}

	public void setParisUtilisateur(Collection<Pari> parisUtilisateur) {
		this.parisUtilisateur = parisUtilisateur;
	}

	private Collection<Pari> parisUtilisateur;

	private String menuActif; 
	@PostConstruct
	public void init (){
		setMenuActif("accueil");
		parisUtilisateur =pariService.findAllPariUtilisateur(authbean.getUtilisateur());
	}

	public boolean comp(Date date2, Date date1){
		if(date1.compareTo(date2)>0){
			return true;
		}
		return false;
		}
	
	public String getMenuActif() {
		return menuActif;
	}

	public void setMenuActif(String menuActif) {
		this.menuActif = menuActif;
	}


	public Collection<Pari> getParisUtilisateur() {
		return parisUtilisateur;
	}

	public void setParisUtilisateur(List<Pari> parisUtilisateur) {
		this.parisUtilisateur = parisUtilisateur;
	}

	public PariService getPariService() {
		return pariService;
	}

	public void setPariService(PariService pariService) {
		this.pariService = pariService;
	}

	public List<UtilisateurClassemment> getUtilisateurClassemments() {
		return utilisateurClassemments;
	}

	public void setUtilisateurClassemments(List<UtilisateurClassemment> utilisateurClassemments) {
		this.utilisateurClassemments = utilisateurClassemments;
	}
	public void 	enregistrementPari(){


		for (Pari pari : parisUtilisateur) {
			if (DateUtil.compare(pari.getMatchs().getDebut()))
				pariService.updatePari(pari);

		}

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Les paris sont enregistrés !"));

	}

}


