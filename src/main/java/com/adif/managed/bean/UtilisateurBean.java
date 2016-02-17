package com.adif.managed.bean;

import java.io.InputStream;
import java.io.Serializable;
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

import com.adif.model.Pari;
import com.adif.model.Score;
import com.adif.model.Utilisateur;
import com.adif.service.PariService;
import com.adif.service.UtilisateurService;

@Named
@Scope("session")
public class UtilisateurBean implements Serializable {

	private static final long serialVersionUID = 1L;


	@Inject
	private UtilisateurService utilisateurService;
	
	@Inject
	private PariService pariService;

	@Inject
	private InitBean initBean;

	List<Utilisateur> utilisateurList;

	private int idClient;

	private Utilisateur utilisateur;

	private Part file;

	public String upload() {
		try
		{
			InputStream in = file.getInputStream();	       

			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(in);

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();


			while (rowIterator.hasNext())
			{
				Row row = rowIterator.next();
				Score score;
				if (row.getRowNum()>6 &&  row.getRowNum()!=14
						&&  row.getRowNum()!=14
						&&  row.getRowNum()!=13
						&&  row.getRowNum()!=22
						&&  row.getRowNum()!=21
						&&  row.getRowNum()!=30
						&&  row.getRowNum()!=29
						&&  row.getRowNum()!=38	
						&&  row.getRowNum()!=37
						&&  row.getRowNum()!=46
						&&  row.getRowNum()!=45
						&&  row.getRowNum()!=54
						&&  row.getRowNum()!=53
						&&  row.getRowNum()!=62
						&&  row.getRowNum()!=61
						&&  row.getRowNum()<69){
					Iterator<Cell> cellIterator = row.cellIterator();
					cellIterator.next();
					Cell cell =cellIterator.next();
					
				
					int nMatch =Double.valueOf(cell.getNumericCellValue()).intValue();
					System.out.println(nMatch);
					System.out.println(utilisateur.getId());
				Pari pari = pariService.findPariUtilisateurAndOrdre(utilisateur,nMatch);
					cellIterator.next();
					cellIterator.next();		
					cellIterator.next();		
score=pari.getScore();
score.setButEquipe1(Double.valueOf(cellIterator.next().getNumericCellValue()).intValue());
score.setButEquipe2(Double.valueOf(cellIterator.next().getNumericCellValue()).intValue());		
pari.setScore(score);
pariService.updatePari(pari);
				}
			}
			in.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", "Erreur lors de l'importation pour" +utilisateur.getPrenom()+ "!"));
initBean.ouvrirFermerUtilisateur(utilisateur);
initBean.ouvrirPariUtilisateur(utilisateur);

		}
pariService.calculPoint(utilisateur);
initBean.calculClassement();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Importation réussie pour" +utilisateur.getPrenom()+ "!"));
return null;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}


	@PostConstruct
	private void init(){

		utilisateurList= utilisateurService.findAll();
		utilisateur= utilisateurList.get(0);
	}

	public void addUtilisateur() {
		this.utilisateur =utilisateurService.addUtilisateur(this.utilisateur);
		//ouvrir les paris
		initBean.ouvrirPariUtilisateur(this.utilisateur);
		utilisateur= new Utilisateur();
		utilisateurList= utilisateurService.findAll();
	}
	
	public void deleteUtilisateur(Utilisateur utilisateur) {
		initBean.ouvrirFermerUtilisateur(utilisateur);
		initBean.calculClassement();
		utilisateurService.deleteUtilisateur(utilisateur);

		utilisateurList= utilisateurService.findAll();
	}

	public void reset() {
		utilisateur= new Utilisateur();
	}

	public List<Utilisateur> getUtilisateurList() {
		return utilisateurList;
	}
	public void updateUtilisateur() {

		utilisateurService.updateUtilisateur(this.utilisateur);

		utilisateurList= utilisateurService.findAll();
	}

	public Utilisateur getUtilisateur(int id) {

		return utilisateurService.getUtilisateurById(id); 

	}
	public UtilisateurService getUtilisateurService() {
		return utilisateurService;
	}

	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	public void setUtilisateurList(List<Utilisateur> utilisateurList) {
		this.utilisateurList = utilisateurList;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public InitBean getInitBean() {
		return initBean;
	}

	public void setInitBean(InitBean initBean) {
		this.initBean = initBean;
	}

	public PariService getPariService() {
		return pariService;
	}

	public void setPariService(PariService pariService) {
		this.pariService = pariService;
	}

}