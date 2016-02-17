package com.adif.utils;


import java.io.Serializable;
import java.util.Map;

import javax.faces.application.ProjectStage;
import javax.faces.context.FacesContext;


import com.adif.model.Utilisateur;



public class JsfUtils implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7828638665714895757L;

	public static void setAuthenticated(Utilisateur utilisateur) {
		FacesContext lFacesContext = FacesContext.getCurrentInstance();
		final Map<String, Object> lSessionMap = lFacesContext.getExternalContext().getSessionMap();
		lSessionMap.put("user", utilisateur);

	}

	public boolean isAuthenticated() {

		return getUserAuthenticated() != null;

	}
		

	public static  Utilisateur getUserAuthenticated() {
		FacesContext lFacesContext = FacesContext.getCurrentInstance();
		final Map<String, Object> lSessionMap = lFacesContext.getExternalContext().getSessionMap();
		Utilisateur utilisateur = (Utilisateur) lSessionMap.get("user");

		return utilisateur;

	}

	public String getTraceMessage() {
		FacesContext lFacesContext = FacesContext.getCurrentInstance();

		final Map<String, Object> lSessionMap = lFacesContext.getExternalContext().getSessionMap();
		return (String) lSessionMap.get("exceptionMessage");

	}

	public String getTraceException() {
		FacesContext lFacesContext = FacesContext.getCurrentInstance();

		final Map<String, Object> lSessionMap = lFacesContext.getExternalContext().getSessionMap();
		return (String) lSessionMap.get("exceptionTrace");

	}

	public boolean getProjectStageDevelopment() {

		return FacesContext.getCurrentInstance().isProjectStage(ProjectStage.Development);
	}

	public boolean deleteAuthenticated() {
		FacesContext lFacesContext = FacesContext.getCurrentInstance();
		final Map<String, Object> lSessionMap = lFacesContext.getExternalContext().getSessionMap();
		Object lAuthBean = lSessionMap.remove("user");

		return lAuthBean != null;

	}
	
}
