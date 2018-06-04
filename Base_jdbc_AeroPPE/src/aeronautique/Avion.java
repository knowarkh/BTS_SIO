package aeronautique;

public class Avion {
	
	//---Attributs de la class Avion---
	private int numAv;
	private String nomAv;
	private int capacite;
	private String loc;

	//---Constructeur sur les champs---
	public Avion(String nomAv, int capacite, String loc) {
		super();
		this.numAv = -1;
		this.nomAv = nomAv;
		this.capacite = capacite;
		this.loc = loc;
	}

	//---Getters & Setters---
	public int getNumAv() {
		return numAv;
	}

	public void setNumAv(int numAv) {
		this.numAv = numAv;
	}

	public String getNomAv() {
		return nomAv;
	}

	public void setNomAv(String nomAv) {
		this.nomAv = nomAv;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Avion [numAv=" + numAv + ", nomAv=" + nomAv + ", capacite=" + capacite + ", loc=" + loc + "]";
	}

}
