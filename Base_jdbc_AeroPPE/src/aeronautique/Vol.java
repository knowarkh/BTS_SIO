package aeronautique;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;


public class Vol {
	
	//---Attributs de la class Vol---
	private int numVol;
	private Pilote pilote;
	private Avion avion;
	private String villeDep;
	private String villeArr;
	private GregorianCalendar hDep;
	private GregorianCalendar hArr;
	 
	//---Constructeur sur les champs---
	public Vol(Pilote pilote, Avion avion, String villeDep, String villeArr, GregorianCalendar hDep, GregorianCalendar hArr) {
		super();
		this.numVol = -1;
		this.pilote = pilote;
		this.avion = avion;
		this.villeDep = villeDep;
		this.villeArr = villeArr;
		this.hDep = hDep;
		this.hArr = hArr;
	}
	
	//---Getters & Setters---
	public int getNumVol() {
		return numVol;
	}

	public void setNumVol(int numVol) {
		this.numVol = numVol;
	}

	public Pilote getPilote() {
		return pilote;
	}

	public void setPilote(Pilote pilote) {
		this.pilote = pilote;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public String getVilleDep() {
		return villeDep;
	}

	public void setVilleDep(String villeDep) {
		this.villeDep = villeDep;
	}

	public String getVilleArr() {
		return villeArr;
	}

	public void setVilleArr(String villArr) {
		this.villeArr = villArr;
	}

	public GregorianCalendar gethDep() {
		return hDep;
	}

	public void sethDep(GregorianCalendar hDep) {
		this.hDep = hDep;
	}

	public GregorianCalendar gethArr() {
		return hArr;
	}

	public void sethArr(GregorianCalendar hArr) {
		this.hArr = hArr;
	}

	/**
	 * éventuellement utiliser java.sql.Timestamp et getTimeInMillis pour afficher les dates 
	 */
	@Override
	public String toString() {
		SimpleDateFormat simp1 = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss", Locale.FRENCH);
		//SimpleDateFormat simp2 = new SimpleDateFormat("dd MMMM yyyy zzzz G", Locale.FRENCH);
		String date1 = simp1.format(hDep.getTime());
		String date2 = simp1.format(hArr.getTime());
		return "Vol [numVol=" + numVol + ", numPil=" + this.getPilote().getNumPil() + ", numAv=" + this.getAvion().getNumAv() + ", villeDep=" + villeDep + ", villeArr=" + villeArr + ", hDep=" + date1 + ", hArr=" + date2 + "]";
	}

}
