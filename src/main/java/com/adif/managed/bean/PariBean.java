package com.adif.managed.bean;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.adif.model.Pari;
import com.adif.service.EquipeService;
import com.adif.service.PariService;

@Named
@Scope("session")
public class PariBean {

	@Inject
	private PariService pariService;
	
	@Inject
	private EquipeService equipeService;
	
	private List<Pari> pariList;
	private Pari pari;
	
	private int id1;
	private int id2;
	
	@PostConstruct
	public void init (){
		pari= new Pari();
		pariList= pariService.findAllPari();

	}

	public void addPari() {
	
		
		pariService.addPari(this.pari);

		pariList= pariService.findAllPari();
	}
	public void deletePari(Pari pari) {

		pariService.deletePari(pari);

		pariList= pariService.findAllPari();
	}
	
	public void reset() {
		pari= new Pari();
	}

	public PariService getPariService() {
		return pariService;
	}

	public void setPariService(PariService pariService) {
		this.pariService = pariService;
	}

	public List<Pari> getPariList() {
		return pariList;
	}

	public void setPariList(List<Pari> pariList) {
		this.pariList = pariList;
	}

	public Pari getPari() {
		return pari;
	}

	public void setPari(Pari pari) {
		this.pari = pari;
	}

	public int getId1() {
		return id1;
	}

	public void setId1(int id1) {
		this.id1 = id1;
	}

	public int getId2() {
		return id2;
	}

	public void setId2(int id2) {
		this.id2 = id2;
	}

	public EquipeService getEquipeService() {
		return equipeService;
	}

	public void setEquipeService(EquipeService equipeService) {
		this.equipeService = equipeService;
	}

}


