package com.adif.managed.bean;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.adif.model.Equipe;
import com.adif.service.EquipeService;

@Named
@Scope("session")
public class EquipeBean {

	@Inject
	private EquipeService EquipeService;
	
	private List<Equipe> EquipeList;
	private Equipe Equipe;
	
	@PostConstruct
	public void init (){
		Equipe= new Equipe();
		EquipeList= EquipeService.findAll();
	}

	public void addEquipe() {
		EquipeService.addEquipe(this.Equipe);

		EquipeList= EquipeService.findAll();
	}
	
	public void updateEquipe() {
		EquipeService.updateEquipe(this.Equipe);

		EquipeList= EquipeService.findAll();
	}
	public void deleteEquipe(Equipe Equipe) {

		EquipeService.deleteEquipe(Equipe);

		EquipeList= EquipeService.findAll();
	}
	
	public void reset() {
		Equipe= new Equipe();
	}

	public EquipeService getEquipeService() {
		return EquipeService;
	}

	public void setEquipeService(EquipeService EquipeService) {
		this.EquipeService = EquipeService;
	}

	public List<Equipe> getEquipeList() {
		return EquipeList;
	}

	public void setEquipeList(List<Equipe> EquipeList) {
		this.EquipeList = EquipeList;
	}

	public Equipe getEquipe() {
		return Equipe;
	}

	public void setEquipe(Equipe Equipe) {
		this.Equipe = Equipe;
	}

}


