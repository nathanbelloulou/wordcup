package com.adif.managed.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;


import com.adif.model.Equipe;
import com.adif.model.Groupe;
import com.adif.model.Pari;
import com.adif.model.Utilisateur;
import com.adif.presentation.UtilisateurClassemment;
import com.adif.service.EquipeService;
import com.adif.service.GroupeService;
import com.adif.service.MatchService;
import com.adif.service.PariService;
import com.adif.service.UtilisateurService;

@Named
@ApplicationScoped
public class InitBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EquipeService equipeService;

	@Inject
	private PariService pariService ;

	@Inject
	private GroupeService groupeService ;

	@Inject
	private MatchService matchService;

	@Inject
	private UtilisateurService utilisateurService;
	



	private String reglement ="<font size=\"3\"><span style=\"text-decoration: underline;\">Trois règles de calcul des points:</span></font><br><ul><li><font size=\"3\">Différence de but : 1 point<br></font></li><li><font size=\"3\">Le score juste : 1 point<br></font></li><li><font size=\"3\">Le gagnant : 2points</font><br></li></ul>";

	private ArrayList<UtilisateurClassemment> utilisateurClassemments;
	@PostConstruct
	public void init(){
		if(utilisateurService.findAll().size()==0){

			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setNom("Belloulou");
			utilisateur.setPrenom("Nathan");
			utilisateur.setMotpasse("nat");
			utilisateur.setAbilitationAdministrateur(false);
			utilisateur.setIdentifiant("nat");
			utilisateurService.addUtilisateur(utilisateur);
			utilisateur= utilisateurService.getUtilisateurById(1);
			Utilisateur utilisateur2 = new Utilisateur();
			utilisateur2.setNom("admin");
			utilisateur2.setPrenom("admin");
			utilisateur2.setMotpasse("nat");
			utilisateur2.setAbilitationAdministrateur(true);
			utilisateur2.setIdentifiant("admin");
			utilisateurService.addUtilisateur(utilisateur2);


						
			Groupe groupeA = new Groupe();
			groupeA.setLibelle('A');
			Groupe groupeB = new Groupe();
			groupeB.setLibelle('B');
			Groupe groupeC = new Groupe();
			groupeC.setLibelle('C');
			Groupe groupeD = new Groupe();
			groupeD.setLibelle('D');
			Groupe groupeE = new Groupe();
			groupeE.setLibelle('E');
			Groupe groupeF = new Groupe();
			groupeF.setLibelle('F');
			Groupe groupeG = new Groupe();
			groupeG.setLibelle('G');
			Groupe groupeH = new Groupe();
			groupeH.setLibelle('H');

			Equipe equipe1 = new Equipe();
			equipe1.setLibelle("Brésil");
			equipe1.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-01352___42x22.png");
			equipe1.setGroupe(groupeA);
			equipeService.addEquipe(equipe1);
			Equipe equipe2 = new Equipe();
			equipe2.setLibelle("Cameroun");
			equipe2.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03yl2t__42x22.png");
			equipe2.setGroupe(groupeA);
			equipeService.addEquipe(equipe2);
			Equipe equipe3 = new Equipe();
			equipe3.setLibelle("Mexique");
			equipe3.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03dj48__42x22.png");
			equipe3.setGroupe(groupeA);
			equipeService.addEquipe(equipe3);
			Equipe equipe4 = new Equipe();
			equipe4.setLibelle("Croatie");
			equipe4.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-0356gk__42x22.png");
			equipe4.setGroupe(groupeA);
			equipeService.addEquipe(equipe4);
			Equipe equipe5 = new Equipe();
			equipe5.setLibelle("Australie");
			equipe5.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-0cnk2q__42x22.png");
			equipe5.setGroupe(groupeB);
			equipeService.addEquipe(equipe5);
			Equipe equipe6 = new Equipe();
			equipe6.setLibelle("Chili");
			equipe6.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-033nzk__42x22.png");
			equipe6.setGroupe(groupeB);
			equipeService.addEquipe(equipe6);
			Equipe equipe7 = new Equipe();
			equipe7.setLibelle("Pays-Bas");
			equipe7.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-02ltg3__42x22.png");
			equipe7.setGroupe(groupeB);
			equipeService.addEquipe(equipe7);
			Equipe equipe8 = new Equipe();
			equipe8.setLibelle("Espagne");
			equipe8.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-02w64f__42x22.png");
			equipe8.setGroupe(groupeB);
			equipeService.addEquipe(equipe8);
			Equipe equipe9 = new Equipe();
			equipe9.setLibelle("Colombie");
			equipe9.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-032c08__42x22.png");
			equipe9.setGroupe(groupeC);
			equipeService.addEquipe(equipe9);
			Equipe equipe10 = new Equipe();
			equipe10.setLibelle("Côte d'Ivoire");
			equipe10.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-040pyq__42x22.png");
			equipe10.setGroupe(groupeC);
			equipeService.addEquipe(equipe10);
			Equipe equipe11 = new Equipe();
			equipe11.setLibelle("Grèce");
			equipe11.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-035qgm__42x22.png");
			equipe11.setGroupe(groupeC);
			equipeService.addEquipe(equipe11);
			Equipe equipe12 = new Equipe();
			equipe12.setLibelle("Japon");
			equipe12.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03xh50__42x22.png");
			equipe12.setGroupe(groupeC);
			equipeService.addEquipe(equipe12);
			Equipe equipe13 = new Equipe();
			equipe13.setLibelle("Costa Rica");
			equipe13.setGroupe(groupeD);
			equipe13.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03zb6t__42x22.png");
			equipeService.addEquipe(equipe13);
			Equipe equipe14 = new Equipe();
			equipe14.setLibelle("Angleterre");
			equipe14.setGroupe(groupeD);
			equipe14.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-02pp1__42x22.png");
			equipeService.addEquipe(equipe14);
			Equipe equipe15 = new Equipe();
			equipe15.setLibelle("Italie");
			equipe15.setGroupe(groupeD);
			equipe15.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-01_lhg__42x22.png");
			equipeService.addEquipe(equipe15);
			Equipe equipe16 = new Equipe();
			equipe16.setLibelle("Uruguay");
			equipe16.setGroupe(groupeD);
			equipe16.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-0329r5__42x22.png");
			equipeService.addEquipe(equipe16);
			Equipe equipe17 = new Equipe();
			equipe17.setLibelle("Equateur");
			equipe17.setGroupe(groupeE);
			equipe17.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03zj_3__42x22.png");
			equipeService.addEquipe(equipe17);
			Equipe equipe18 = new Equipe();
			equipe18.setLibelle("France");
			equipe18.setGroupe(groupeE);
			equipe18.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-01l3vx__42x22.png");
			equipeService.addEquipe(equipe18);
			Equipe equipe19 = new Equipe();
			equipe19.setLibelle("Honduras");
			equipe19.setGroupe(groupeE);
			equipe19.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03z8bw__42x22.png");
			equipeService.addEquipe(equipe19);
			Equipe equipe20 = new Equipe();
			equipe20.setLibelle("Suisse");
			equipe20.setGroupe(groupeE);
			equipe20.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-032jlh__42x22.png");
			equipeService.addEquipe(equipe20);
			Equipe equipe21 = new Equipe();
			equipe21.setLibelle("Argentine");
			equipe21.setGroupe(groupeF);
			equipe21.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-02bh_v__42x22.png");
			equipeService.addEquipe(equipe21);
			Equipe equipe22 = new Equipe();
			equipe22.setLibelle("Bosnie");
			equipe22.setGroupe(groupeF);
			equipe22.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03yv9r__42x22.png");
			equipeService.addEquipe(equipe22);
			Equipe equipe23 = new Equipe();
			equipe23.setLibelle("Iran");
			equipe23.setGroupe(groupeF);
			equipe23.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-01n_2f__42x22.png");
			equipeService.addEquipe(equipe23);
			Equipe equipe24 = new Equipe();
			equipe24.setLibelle("Nigéria");
			equipe24.setGroupe(groupeF);
			equipe24.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03ylxn__42x22.png");
			equipeService.addEquipe(equipe24);
			Equipe equipe25 = new Equipe();
			equipe25.setLibelle("Allemagne");
			equipe25.setGroupe(groupeG);
			equipe25.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-01l3wr__42x22.png");
			equipeService.addEquipe(equipe25);
			Equipe equipe26 = new Equipe();
			equipe26.setLibelle("Ghana");
			equipe26.setGroupe(groupeG);
			equipe26.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03_qrp__42x22.png");
			equipeService.addEquipe(equipe26);
			Equipe equipe27 = new Equipe();
			equipe27.setLibelle("Portugal");
			equipe27.setGroupe(groupeG);
			equipe27.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-02rqxc__42x22.png");
			equipeService.addEquipe(equipe27);
			Equipe equipe28 = new Equipe();
			equipe28.setLibelle("Etats-Unis");
			equipe28.setGroupe(groupeG);
			equipe28.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-02s9vc__42x22.png");
			equipeService.addEquipe(equipe28);
			Equipe equipe29 = new Equipe();
			equipe29.setLibelle("Algérie");
			equipe29.setGroupe(groupeH);
			equipe29.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03_qj1__42x22.png");
			equipeService.addEquipe(equipe29);
			Equipe equipe30 = new Equipe();
			equipe30.setLibelle("Belgique");
			equipe30.setGroupe(groupeH);
			equipe30.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-0329gm__42x22.png");
			equipeService.addEquipe(equipe30);
			Equipe equipe32 = new Equipe();
			equipe32.setLibelle("Corée du Sud");
			equipe32.setGroupe(groupeH);
			equipe32.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03zrhb__42x22.png");
			equipeService.addEquipe(equipe32);
			Equipe equipe31 = new Equipe();
			equipe31.setLibelle("Russie");
			equipe31.setGroupe(groupeH);
			equipe31.setLienImage("http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03262k__42x22.png");
			equipeService.addEquipe(equipe31);
		    }

	

			
			calculClassement();
		

	}
	
public void calculClassement(){
	 utilisateurClassemments= new ArrayList<UtilisateurClassemment>();
	 List<Utilisateur> utilisateurs = utilisateurService.findAllUtilisateurs();
	 List<Pari> parisUtilisateur;
		for (Utilisateur utilisateur : utilisateurs) {
			UtilisateurClassemment utilisateurClassemment=new UtilisateurClassemment();
			utilisateurClassemment.setUtilisateur(utilisateur);
			parisUtilisateur =pariService.findAllPariUtilisateur(utilisateur);
			
		int point=0;
		
			for (Pari pari : parisUtilisateur) {
			
				point=point+pari.getPointDiff()+pari.getPointGagnant()+pari.getScoreExact();
				
				
			}
			
			utilisateurClassemment.setScore(point);
			
			utilisateurClassemments.add(utilisateurClassemment);
		}
 }
	

	public ArrayList<UtilisateurClassemment> getUtilisateurClassemments() {
	return utilisateurClassemments;
}

public void setUtilisateurClassemments(
		ArrayList<UtilisateurClassemment> utilisateurClassemments) {
	this.utilisateurClassemments = utilisateurClassemments;
}

	public void ouvrirPariUtilisateur(Utilisateur utilidateur){
		pariService.ouvrirPariMatch(Arrays.asList(utilidateur), matchService.findAll());
		calculClassement();
	}
	
	
	public void ouvrirFermerUtilisateur(Utilisateur utilidateur){
		List<Pari> paris=pariService.findAllPariUtilisateur(utilidateur);
		for (Pari pari : paris) {
			pariService.deletePari(pari);
			
		}
	}



	public UtilisateurService getUtilisateurService() {
		return utilisateurService;
	}


	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	public EquipeService getEquipeService() {
		return equipeService;
	}

	public void setEquipeService(EquipeService equipeService) {
		this.equipeService = equipeService;
	}

	public PariService getPariService() {
		return pariService;
	}

	public void setPariService(PariService pariService) {
		this.pariService = pariService;
	}

	public MatchService getMatchService() {
		return matchService;
	}

	public void setMatchService(MatchService matchService) {
		this.matchService = matchService;
	}

	public String getReglement() {
		return reglement;
	}

	public void setReglement(String reglement) {
		this.reglement = reglement;
	}

	public GroupeService getGroupeService() {
		return groupeService;
	}

	public void setGroupeService(GroupeService groupeService) {
		this.groupeService = groupeService;
	}
}