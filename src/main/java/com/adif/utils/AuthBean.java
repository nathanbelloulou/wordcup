package com.adif.utils;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;

import com.adif.model.Utilisateur;
import com.adif.service.UtilisateurService;

@Named
@Scope("session")
public class AuthBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(AuthBean.class);

	private String username ;

	private String password ;

	private Utilisateur utilisateur;


	@Inject
	UtilisateurService utilisateurService;

	@PostConstruct
	public void init() {
	}

	public String doLogout() {
		utilisateur=null;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
	            .getExternalContext().getSession(false);
	    session.invalidate();
		return "logoutSuccess";
		

	}


	public String doLogin() {
		
		LOG.debug("Authentification user : " + username);
		 setUtilisateur(utilisateurService.getUtilisateurByIdentifiant(username));
		if(utilisateur.getMotpasse().equals(password)){
			LOG.debug(username + " authentified");
			return "loginSuccess";
		}
		utilisateur=null;
		return "loginRetry";
	}
	public void isIdentifier(ComponentSystemEvent event){


		if (utilisateur==null){

			redirection("/login.xhtml");
		}		
	}	
	public void redirection(String urla) {
		ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();

		String url = extContext.encodeActionURL(FacesContext.getCurrentInstance().getApplication().getViewHandler().getActionURL(FacesContext.getCurrentInstance(), urla));

		try {
			extContext.redirect(url);
		} catch (IOException ioe) {
			throw new FacesException(ioe);
		}
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String aUsername) {
		username = aUsername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String aPassword) {
		password = aPassword;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}






}
