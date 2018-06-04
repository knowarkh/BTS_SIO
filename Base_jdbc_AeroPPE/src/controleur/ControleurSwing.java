package controleur;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import aeronautique.Avion;
import aeronautique.Pilote;
import aeronautique.Vol;
import dao.AvionDAO;
import dao.PiloteDAO;
import dao.VolDAO;

public class ControleurSwing {

	private static ControleurSwing instance = null;
	
	public static ControleurSwing getInstance() {
		if (instance==null) {
			try { 
				instance = new ControleurSwing();
			}
			catch(Exception e){
				System.out.println("Echec : " + e.getMessage() + e.getStackTrace()) ;
			}
		}
		return instance;
	}

	
	public void creerAvion(String nom, int capacite, String loc) {
		AvionDAO avionDao = AvionDAO.getInstance();
		Avion avion = new Avion(nom, capacite, loc);
		avionDao.create(avion);
	}
	
	public void delAvion (int id) {
        AvionDAO avionDao = AvionDAO.getInstance();
        Avion avion = new Avion("", 0, "");
        avion.setNumAv(id);
        avionDao.delete(avion);
    }
	
	public void updAvion (int id, String nom, int cap, String loc) {
		Avion avion = new Avion(nom, cap, loc);
		avion.setNumAv(id);
		AvionDAO aDAO = AvionDAO.getInstance();
		aDAO.update(avion);
	}
	
	public void creerPilote(String nom, String adr, int sal) {
		Pilote pilote = new Pilote(nom, adr, sal);
		PiloteDAO pDAO = PiloteDAO.getInstance();
		pDAO.create(pilote);
	}
	
	public void delPilote(int id) {
		Pilote pilote = new Pilote("", "", 0);
		PiloteDAO pDAO = PiloteDAO.getInstance();
		pilote.setNumPil(id);
		pDAO.delete(pilote);
	}
	
	public void updPilote(int id, String nom, String adr, int sal) {
		Pilote pilote = new Pilote(nom, adr, sal);
		pilote.setNumPil(id);
		PiloteDAO pDAO = PiloteDAO.getInstance();
		pDAO.update(pilote);
	}
	
	public void creerVol(int idPil, int idAv, String ville_Dep, String ville_Arr, String h_Dep, String h_Arr) {
		Pilote pilote = new Pilote("", "", 0);
		pilote.setNumPil(idPil);
		Avion avion = new Avion("", 0, "");
		avion.setNumAv(idAv);
		Vol vol = new Vol(pilote, avion, ville_Dep, ville_Arr, convertDateString(h_Dep), convertDateString(h_Arr));
		VolDAO vDAO = VolDAO.getInstance();
		vDAO.create(vol);
	}
	
	public void delVol(int id) {
		Avion avion = new Avion("", 0,"");
		Pilote pilote = new Pilote("", "", 0);
		Vol vol = new Vol(pilote, avion, "", "", null, null);
		VolDAO vDAO = VolDAO.getInstance();
		vol.setNumVol(id);
		vDAO.delete(vol);
	}
	
	public void updVol(int id, int idPil, int idAv, String ville_Dep, String ville_Arr, String h_Dep, String h_Arr) {
		Pilote pilote = new Pilote("", "", 0);	
		pilote.setNumPil(idPil);
		Avion avion = new Avion("", 0, "");
		avion.setNumAv(idAv);
		Vol vol = new Vol(pilote, avion, ville_Dep, ville_Arr, convertDateString(h_Dep), convertDateString(h_Arr));
		vol.setNumVol(id);
		VolDAO vDAO = VolDAO.getInstance();
		vDAO.update(vol);
	}
	
	public GregorianCalendar convertDateString(String dateString)  {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		java.util.Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		GregorianCalendar calender = new GregorianCalendar();
		calender.setTime(date);
		return calender;
	}
}
