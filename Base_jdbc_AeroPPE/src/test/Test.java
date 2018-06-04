package test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import aeronautique.Avion;
import aeronautique.Pilote;
import aeronautique.Vol;
import dao.AvionDAO;
import dao.Connexion;
import dao.PiloteDAO;
import dao.VolDAO;

public class Test {

	public static void main(String[] args) {

		//---Test connexion à la BDD---

		//Connexion c = new Connexion();
		//Connexion.getInstance();
		//c.fermer();

		//---Tests script creation de table et insertion de tuple---

		//		String requeteCreateTablePilote = "CREATE TABLE aeronautiquePPE.dbo.PILOTE\r\n" + 
		//				"	(numPil int IDENTITY(1,1) PRIMARY KEY not NULL,\r\n" + 
		//				"	nomPil varchar(100) not NULL,\r\n" + 
		//				"	adr varchar(100) not NULL,\r\n" + 
		//				"	sal int not NULL);";
		//		Connexion.executeUpdate(requeteCreateTablePilote);
		//		String requeteTestInsertTuple = "INSERT INTO aeronautiquePPE.dbo.PILOTE (nomPil,adr,sal)\r\n" + 
		//				"VALUES ('Jean','Nantes','15000');";
		//		Connexion.executeUpdate(requeteTestInsertTuple);
		//		Connexion.fermer();
		//		String requeteTestInsertTuple2 = "INSERT INTO aeronautiquePPE.dbo.PILOTE (nomPil,adr,sal)\r\n" + 
		//				"VALUES ('Mat','Rennes','13000');";
		//		Connexion.executeUpdate(requeteTestInsertTuple2);
		//		Connexion.fermer();


		//---Appel méthode initialisation -> création des tables et remplissage---

		//initialisation();


		//---Test méthodes afficherSelectEtoile et getMaxId de la class Connexion---

		//		Connexion.afficheSelectEtoile("PILOTE", "sal>5000");
		//		System.out.println("------");
		//		System.out.println(Connexion.getMaxId("numPil", "PILOTE"));
		//		Connexion.fermer();

		//---Test CRUD classe PiloteDAO---

		createPilote("Alexis","Locmine",15000);
		deletePilote("null","null",0,12);
		updatePilote("Thomas","Vannes",15000,10);
		readPilote(10);


		//---Test CRUD classe AvionDAO---

		createAvion("boeing",320,"Lyon");
		deleteAvion("null", 0, "null", 8);
		updateAvion("boeing", 250, "Lyon", 9);
		readAvion(3);

		//---Test CRUD classe VolDAO---

		GregorianCalendar hDep1 = new GregorianCalendar(2017,Calendar.DECEMBER,12,8,30,00);
		GregorianCalendar hArr1 = new GregorianCalendar(2017,Calendar.DECEMBER,12,9,30,00);
		Pilote pil = new Pilote("Deckard","Vannes",20000);
		pil.setNumPil(4);
		Avion av = new Avion("boeing",300,"Paris");
		av.setNumAv(7);

		createVol(pil,av,"Paris","Vannes",hDep1,hArr1);
		deleteVol(pil,av,"null","null",hDep1,hArr1,15);
		updateVol(pil,av,"Rennes","Bordeaux",hDep1,hArr1,16);
		readVol(7);
	}



	private static void readVol(int ident) {
		VolDAO volDAO = VolDAO.getInstance();
		//VolDAO volDAO1 = new VolDAO();
		System.out.println(volDAO.read(ident));
		Connexion.fermer();
	}

	private static void updateVol(Pilote pilote, Avion avion, String villeDep, String villeArr , GregorianCalendar hDep, GregorianCalendar hArr, int ident) {
		Vol vol1 = new Vol(pilote, avion, villeDep, villeArr , hDep, hArr);
		vol1.setNumVol(ident);
		VolDAO volDAO = VolDAO.getInstance();
		//VolDAO volDAO1 = new VolDAO();
		System.out.println(volDAO.update(vol1));
		Connexion.fermer();
	}

	private static void deleteVol(Pilote pilote, Avion avion, String villeDep, String villeArr , GregorianCalendar hDep, GregorianCalendar hArr, int ident) {
		Vol vol1 = new Vol(pilote, avion, villeDep, villeArr , hDep, hArr);
		vol1.setNumVol(ident);
		VolDAO volDAO = VolDAO.getInstance();
		//VolDAO volDAO1 = new VolDAO();
		System.out.println(volDAO.delete(vol1));
		Connexion.fermer();
	}

	private static void createVol(Pilote pilote, Avion avion, String villeDep, String villeArr , GregorianCalendar hDep, GregorianCalendar hArr) {
		Vol vol1 = new Vol(pilote, avion, villeDep, villeArr , hDep, hArr);
		VolDAO volDAO = VolDAO.getInstance();
		//VolDAO volDAO1 = new VolDAO();
		System.out.println(volDAO.create(vol1));
		Connexion.fermer();
	}

	private static void readAvion(int ident) {
		AvionDAO avionDAO = AvionDAO.getInstance();
		//AvionDAO avionDAO = new AvionDAO();
		System.out.println(avionDAO.read(ident));
		Connexion.fermer();
	}

	private static void updateAvion(String nom, int cap, String localite, int ident) {
		Avion avion1 = new Avion(nom,cap,localite);
		avion1.setNumAv(ident);
		AvionDAO avionDAO = AvionDAO.getInstance();
		//AvionDAO avionDAO1 = new AvionDAO();
		System.out.println(avionDAO.update(avion1));
		Connexion.fermer();
	}

	private static void deleteAvion(String nom, int cap, String localite, int ident) {
		Avion avion1 = new Avion(nom,cap,localite);
		avion1.setNumAv(ident);
		AvionDAO avionDAO = AvionDAO.getInstance();
		//AvionDAO avionDAO1 = new AvionDAO();
		System.out.println(avionDAO.delete(avion1));
		Connexion.fermer();
	}

	private static void createAvion(String nom, int cap, String localite) {
		Avion avion1 = new Avion(nom,cap,localite);
		AvionDAO avionDAO = AvionDAO.getInstance();
		//AvionDAO avionDAO1 = new AvionDAO();
		System.out.println(avionDAO.create(avion1));
		Connexion.fermer();
	}

	private static void readPilote(int ident) {
		//utilisation du patron de conception singleton pour PiloteDAO :
		PiloteDAO piloteDAO = PiloteDAO.getInstance();
		//PiloteDAO piloteDAO = new PiloteDAO();
		System.out.println(piloteDAO.read(ident));
		Connexion.fermer();
	}

	private static void updatePilote(String nom, String ville, int salaire, int ident) {
		Pilote pilote1 = new Pilote(nom,ville,salaire);
		pilote1.setNumPil(ident);
		PiloteDAO piloteDAO = PiloteDAO.getInstance();
		//PiloteDAO piloteDAO1 = new PiloteDAO();
		System.out.println(piloteDAO.update(pilote1));
		Connexion.fermer();
	}

	private static void deletePilote(String nom, String ville, int salaire, int ident) {
		Pilote pilote1 = new Pilote(nom,ville,salaire);
		pilote1.setNumPil(ident);
		PiloteDAO piloteDAO = PiloteDAO.getInstance();
		//PiloteDAO piloteDAO1 = new PiloteDAO();
		System.out.println(piloteDAO.delete(pilote1));
		Connexion.fermer();
	}

	private static void createPilote(String nom, String ville, int salaire) {
		Pilote pilote1 = new Pilote(nom,ville,salaire);
		PiloteDAO piloteDAO = PiloteDAO.getInstance();
		//PiloteDAO piloteDAO1 = new PiloteDAO();
		System.out.println(piloteDAO.create(pilote1));
		Connexion.fermer();
	}
}


