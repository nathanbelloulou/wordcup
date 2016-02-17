package com.adif.managed.bean;



import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Scope;

import com.adif.model.Equipe;
import com.adif.model.Matchs;
import com.adif.model.Score;
import com.adif.service.EquipeService;
import com.adif.service.MatchService;
import com.adif.service.PariService;
import com.adif.service.UtilisateurService;

@Named
@Scope("session")
public class MatchBean {

	@Inject
	private MatchService matchService;

	@Inject
	private EquipeService equipeService;

	@Inject
	private InitBean initBean;
	
	@Inject
	private UtilisateurService utilisateurService ;
	
	@Inject
	private PariService pariService;
	
	private Part file;

	private List<Matchs> matchList;
	private Matchs matchs;

	Score score;

	

	@PostConstruct
	public void init (){
		matchList= matchService.findAll();
		score=  new Score();
	}

	public void setScoreMatch(Matchs match) {
		setMatchs(match);
		if(match.getScore()==null){ 
		score = new  Score();
		}
		else{
			score= match.getScore();
		}
	}

	public void setScore() {
		matchs.setScore(score);
		matchService.updateMatch(matchs);
		pariService.calculPoint(matchs);
		initBean.calculClassement();
		

	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public String importMatch(){
		if (matchList.size()==0){
		 try
	        {
	            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
	            XSSFSheet sheet = workbook.getSheetAt(0);
	            Iterator<Row> rowIterator = sheet.iterator();
	            
	            Matchs match=null;
	            while (rowIterator.hasNext())
	            {
	                Row row = rowIterator.next();
	                match= new Matchs();
	                Iterator<Cell> cellIterator = row.cellIterator();
	                match.setOrdre(Double.valueOf(cellIterator.next().getNumericCellValue()).intValue());
	               Calendar cal = Calendar.getInstance();
	               cal.setTime(cellIterator.next().getDateCellValue());
	               Calendar heure = Calendar.getInstance();
	                heure.setTime(cellIterator.next().getDateCellValue());
	                cal.add(Calendar.HOUR, heure.get(Calendar.HOUR));
	                cal.add(Calendar.AM_PM, heure.get(Calendar.AM_PM));
	                match.setDebut(cal.getTime());
	            	match.setEquipe1(equipeService.findByName(cellIterator.next().getStringCellValue()));
	                    cellIterator.next();
	                    cellIterator.next();
		            	match.setEquipe2(equipeService.findByName(cellIterator.next().getStringCellValue()));
	                    match.setLibelle("Matche de pool ");
	                    matchService.addMatch(match);
	            }
	            file.getInputStream().close();
	        }
	        catch (Exception e)
	        {
		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", "Erreur lors de l'importation !"));

	            e.printStackTrace();
	        }
		 
		 matchList =matchService.findAll();
		 
		 pariService.ouvrirPariMatch(utilisateurService.findAllUtilisateurs(), matchList);
		}
		file =null;
		 return null;
		
	}

	public UtilisateurService getUtilisateurService() {
		return utilisateurService;
	}

	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public void addMatch() {
		matchs.setEquipe1(equipeService.getEquipeById(matchs.getEquipe1().getId()));
		matchs.setEquipe2(equipeService.getEquipeById(matchs.getEquipe2().getId()));


		matchService.updateMatch(matchs);

		matchList= matchService.findAll();
	}
	public void switchEquipe(Matchs match) {

		Equipe equipe2 =match.getEquipe1();
		match.setEquipe1(match.getEquipe2());
		match.setEquipe2(equipe2);
		matchService.updateMatch(match);
		matchList= matchService.findAll();
	}

	public void reset() {
		matchs= new Matchs();
	}

	public MatchService getMatchService() {
		return matchService;
	}

	public void setMatchService(MatchService matchService) {
		this.matchService = matchService;
	}

	public List<Matchs> getMatchList() {
		return matchList;
	}

	public void setMatchList(List<Matchs> matchList) {
		this.matchList = matchList;
	}

	public Matchs getMatchs() {
		return matchs;
	}

	public void setMatchs(Matchs matchs) {
		this.matchs = matchs;
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
	
public void enregistrement(){
		for (Matchs match : matchList) {
			matchService.updateMatch(match);;
			
		}
		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Les Matchs sont enregistrés !"));
	}

public InitBean getInitBean() {
	return initBean;
}

public void setInitBean(InitBean initBean) {
	this.initBean = initBean;
}

}


