package controleur;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import aeronautique.Avion;
import aeronautique.Pilote;
import aeronautique.Vol;
import dao.AvionDAO;
import dao.Connexion;
import dao.PiloteDAO;
import dao.VolDAO;
import ihm.console.Menu;

public class Controleur {

	//---Liste des constantes priv�es permettant d'enchainer les menus---
	
	private static final int MENU_PRINCIPAL = 6;
	private static final int MENU_TABLE_VOL = 41;
	private static final int MENU_TABLE_PILOTE = 42;
	private static final int MENU_TABLE_AVION = 43;
	
	//---Menu VOL---
	private static final int MENU_AFFICHER_VOL = 8;
	private static final int MENU_MODIFIER_VOL = 9;
	private static final int MENU_LIRE_VOL = 10;
	
	private static final int MENU_AJOUT_VRAIMENT_VOL = 7;
	private static final int MENU_SUPPR_VRAIMENT_VOL = 13;
	
	//---Menu PILOTE---
	private static final int MENU_AFFICHER_PILOTE = 18;
	private static final int MENU_MODIFIER_PILOTE = 21;
	private static final int MENU_LIRE_PILOTE = 20;
	
	private static final int MENU_AJOUT_VRAIMENT_PILOTE = 17;
	private static final int MENU_SUPPR_VRAIMENT_PILOTE = 19;
	
	//---Menu AVION---
	private static final int MENU_AFFICHER_AVION = 29;
	private static final int MENU_MODIFIER_AVION = 33;
	private static final int MENU_LIRE_AVION = 30;
	
	private static final int MENU_AJOUT_VRAIMENT_AVION = 27;
	private static final int MENU_SUPPR_VRAIMENT_AVION = 31;
	
	public Controleur() {
		this.sgbdJava();
	}

	/**
	 * La m�thode getChoix permet de g�rer les choix faits par l'utilsateur dans le menu 
	 * @param menuAAfficher contient l'entier correspondant au menu � afficher
	 * @return le nouveau choix
	 */
	private int getChoix(int menuAAfficher){
		int rep;
		switch (menuAAfficher) {
		case MENU_PRINCIPAL:
			rep = gererMenuPpl(); 			
			break;
		case MENU_TABLE_PILOTE :
			rep = gererMenuPilote();
			break;
		case MENU_TABLE_AVION :
			rep = gererMenuAvion();
			break;
		case MENU_TABLE_VOL :
			rep = gererMenuVol();
			break;
		default:
			rep=-1;
			break;
		} 
		return rep;
	}


	/**
	 * Sous menu Vol
	 * @return le nouveau choix
	 */
	private int gererMenuVol() {
		int rep;
		Menu.afficheMsg("------------------------");
		Menu.afficheMsg("VOL");
		ArrayList<String> leMenu = new ArrayList<String>();
		leMenu.add("Afficher la table Vol");
		leMenu.add("Ajout d'un Vol");
		leMenu.add("Suppression d'un Vol");
		leMenu.add("Modifification d'un Vol");
		leMenu.add("Afficher les informations d'un Vol");
		leMenu.add("Menu Principal");
		switch (Menu.getChoix(leMenu)) {
		case 0:
			rep=MENU_AFFICHER_VOL;
			break;
		case 1:
			rep=MENU_AJOUT_VRAIMENT_VOL;
			break;	
		case 2:
			rep=MENU_SUPPR_VRAIMENT_VOL;
			break;
		case 3:
			rep=MENU_MODIFIER_VOL;
			break;
		case 4:
			rep=MENU_LIRE_VOL;
			break;
		case 5:
			rep=MENU_PRINCIPAL;
			break;
		default:
			rep=-1;
			break;
		}
		return rep;
	}

	/**
	 * Sous menu Avion
	 * @return le nouveau choix
	 */
	private int gererMenuAvion() {
		int rep;
		Menu.afficheMsg("------------------------");
		Menu.afficheMsg("AVION");
		ArrayList<String> leMenu = new ArrayList<String>();
		leMenu.add("Afficher la table Avion");
		leMenu.add("Ajout d'un Avion");
		leMenu.add("Suppression d'un Avion");
		leMenu.add("Modifification d'un Avion");
		leMenu.add("Afficher les informations d'un Avion");
		leMenu.add("Menu Principal");
		switch (Menu.getChoix(leMenu)) {
		case 0:
			rep=MENU_AFFICHER_AVION;
			break;
		case 1:
			rep=MENU_AJOUT_VRAIMENT_AVION;
			break;	
		case 2:
			rep=MENU_SUPPR_VRAIMENT_AVION;
			break;
		case 3:
			rep=MENU_MODIFIER_AVION;
			break;
		case 4:
			rep=MENU_LIRE_AVION;
			break;
		case 5:
			rep=MENU_PRINCIPAL;
			break;
		default:
			rep=-1;
			break;
		}
		return rep;
	}

	/**
	 * Sous menu Pilote
	 * @return le nouveau choix
	 */
	private int gererMenuPilote() {
		int rep;
		Menu.afficheMsg("------------------------");
		Menu.afficheMsg("PILOTE");
		ArrayList<String> leMenu = new ArrayList<String>();
		leMenu.add("Afficher la table Pilote");
		leMenu.add("Ajout d'un Pilote");
		leMenu.add("Suppression d'un Pilote");
		leMenu.add("Modifification d'un Pilote");
		leMenu.add("Afficher les informations d'un Pilote");
		leMenu.add("Menu Principal");
		switch (Menu.getChoix(leMenu)) {
		case 0:
			rep=MENU_AFFICHER_PILOTE;
			break;
		case 1:
			rep=MENU_AJOUT_VRAIMENT_PILOTE;
			break;	
		case 2:
			rep=MENU_SUPPR_VRAIMENT_PILOTE;
			break;
		case 3:
			rep=MENU_MODIFIER_PILOTE;
			break;
		case 4:
			rep=MENU_LIRE_PILOTE;
			break;
		case 5:
			rep=MENU_PRINCIPAL;
			break;
		default:
			rep=-1;
			break;
		}
		return rep;
	}

	/**
	 * Cette m�thode g�re les enchainements des menus.
	 * 
	 */
	public void sgbdJava(){
		boolean fini=false;
		int choix = this.getChoix(Controleur.MENU_PRINCIPAL);
		int menuPrecedent=choix;
		while (!fini) {
			switch (choix) {
			case -1 :
				fini = true;
				break;
				// Les cas de base ou on appelle simplement le menu demand�
			case Controleur.MENU_PRINCIPAL :
			case Controleur.MENU_TABLE_VOL :
			case Controleur.MENU_TABLE_PILOTE :	
			case Controleur.MENU_TABLE_AVION :
				
				menuPrecedent=choix;
				choix = this.getChoix(choix);
				break;

				// Les cas o� on ne change rien, on ne fait que de l'affichage
			case Controleur.MENU_AFFICHER_VOL :
				Connexion.afficheSelectEtoile("Vol", "numVol>0");
				choix = menuPrecedent;
				break;
			case Controleur.MENU_AFFICHER_PILOTE:
				Connexion.afficheSelectEtoile("PILOTE", "numPil>0");
				choix = menuPrecedent;
				break;
			case Controleur.MENU_AFFICHER_AVION:
				Connexion.afficheSelectEtoile("AVION", "numAv>0");
				choix = menuPrecedent;
				break;

				// Les cas o� on demande des informations pour l'ajout
			case Controleur.MENU_AJOUT_VRAIMENT_VOL :
				this.effectuerAjoutVol();
				choix = menuPrecedent;
				break;
			case Controleur.MENU_AJOUT_VRAIMENT_PILOTE:
				this.effectuerAjoutPilote();
				choix = menuPrecedent;
				break;
			case Controleur.MENU_AJOUT_VRAIMENT_AVION:
				this.effectuerAjoutAvion();
				choix = menuPrecedent;
				break;
				
				// Les cas o� on demande une cl� pour suppression
			case Controleur.MENU_SUPPR_VRAIMENT_VOL :
				this.effectuerSupprVol();
				choix = menuPrecedent;
				break;
			case Controleur.MENU_SUPPR_VRAIMENT_PILOTE:
				this.effectuerSupprPilote();
				choix = menuPrecedent;
				break;
			case Controleur.MENU_SUPPR_VRAIMENT_AVION:
				this.effectuerSupprAvion();
				choix = menuPrecedent;
				break;
				
				// Les cas o� on demande une cl� pour lecture
			case Controleur.MENU_LIRE_PILOTE:
				this.effectuerReadPilote();
				choix = menuPrecedent;
				break;
			case Controleur.MENU_LIRE_AVION:
				this.effectuerReadAvion();
				choix = menuPrecedent;
				break;
			case Controleur.MENU_LIRE_VOL:
				this.effectuerReadVol();
				choix = menuPrecedent;
				break;
				
				// Les cas o� on demande des informations pour la modification
			case Controleur.MENU_MODIFIER_PILOTE:
				this.effectuerUpdatePilote();
				choix = menuPrecedent;
				break;
			case Controleur.MENU_MODIFIER_AVION:
				this.effectuerUpdateAvion();
				choix = menuPrecedent;
				break;
			case Controleur.MENU_MODIFIER_VOL:
				this.effectuerUpdateVol();
				choix = menuPrecedent;
				break;
				
			default:
				// Code inaccessible selon nos v�rifications
				Menu.afficheMsg(" ## R�-essayez");
				break;
			}
		}
		Menu.afficheMsg("Au revoir");
	}


	// ---Appel m�thodes---
	private void effectuerSupprVol() {
		Connexion.afficheSelectEtoile("VOL", "numVol>0");
		Menu.afficheMsg("Quel num�ro de vol supprimer ?");
		//Cr�er une instance de Vol et utiliser delete sur VolDAO :
		int id = Menu.lireInt();
		Vol vol = new Vol(null, null, null, null, null, null);
		VolDAO volDAO = VolDAO.getInstance();
		vol.setNumVol(id);
		Menu.afficheMsg("�tes vous s�r de vouloir supprimer ce vol ?(o/n)");
		String rep = Menu.lireString();
		if (rep.equals("o")) {
			volDAO.delete(vol);	
			Menu.afficheMsg("Vol supprim� !");
			Connexion.afficheSelectEtoile("VOL", "numVol>0");
		}else {
			Menu.afficheMsg("Annulation");
		}
	}
	
	private void effectuerSupprAvion() {
		Connexion.afficheSelectEtoile("AVION", "numAv>0");
		Menu.afficheMsg("Quel num�ro d'avion supprimer ?");	
		int id = Menu.lireInt();
		Avion avion = new Avion(null, 0, null);
		AvionDAO avionDAO = AvionDAO.getInstance();
		avion.setNumAv(id);
		Menu.afficheMsg("�tes vous s�r de vouloir supprimer cet avion ?(o/n)");
		String rep = Menu.lireString();
		if (rep.equals("o")) {
			avionDAO.delete(avion);	
			Menu.afficheMsg("Avion supprim� !");
			Connexion.afficheSelectEtoile("AVION", "numAv>0");
		}else {
			Menu.afficheMsg("Annulation");
		}
	}
	
	private void effectuerSupprPilote() {
		Connexion.afficheSelectEtoile("PILOTE", "numPil>0");
		Menu.afficheMsg("Quel num�ro de Pilote supprimer ?");
		int id = Menu.lireInt();
		Pilote pilote = new Pilote(null, null, 0);
		PiloteDAO piloteDAO = PiloteDAO.getInstance();
		pilote.setNumPil(id);
		Menu.afficheMsg("�tes vous s�r de vouloir supprimer ce Pilote ?(o/n)");
		String rep = Menu.lireString();
		if (rep.equals("o")) {
			piloteDAO.delete(pilote);	
			Menu.afficheMsg("Pilote supprim� !");
			Connexion.afficheSelectEtoile("PILOTE", "numPil>0");
		}else {
			Menu.afficheMsg("Annulation");
		}
	}
	
	private void effectuerAjoutPilote() {
		Menu.afficheMsg("Nom :");
		String nomPil = Menu.lireString();	
		Menu.afficheMsg("Adresse :");
		String adr = Menu.lireString();	
		Menu.afficheMsg("Salaire :");
		int sal = Menu.lireInt();	
		PiloteDAO pilDao = PiloteDAO.getInstance();
		Pilote pil = new Pilote(nomPil,adr, sal);
		pilDao.create(pil);
		Menu.afficheMsg("Pilote ajout� !");
		Connexion.afficheSelectEtoile("PILOTE", "numPil>0");	
	}

	private void effectuerAjoutAvion() {
		Menu.afficheMsg("D�nomination :");
		String nomAv = Menu.lireString();	
		Menu.afficheMsg("Capacit� :");
		int cap = Menu.lireInt();	
		Menu.afficheMsg("Localisation :");
		String loc = Menu.lireString();	
		AvionDAO avDao = AvionDAO.getInstance();
		Avion av = new Avion(nomAv, cap, loc);
		avDao.create(av);
		Menu.afficheMsg("Avion ajout� !");
		Connexion.afficheSelectEtoile("AVION", "numAv>0");
	}
	
	public void effectuerAjoutVol() {
		VolDAO volDao = VolDAO.getInstance();
		Menu.afficheMsg("Quel num�ro de pilote pour ce Vol ?");
		int idPil = Menu.lireInt();
		Pilote pil = new Pilote(null, null, 0);
		pil.setNumPil(idPil);
		Menu.afficheMsg("Quel num�ro d'avion pour ce Vol ?");
		int idAv = Menu.lireInt();
		Avion av = new Avion(null, 0, null);
		av.setNumAv(idAv);
		Menu.afficheMsg("Quel est la ville de d�part du Vol ?");
		String villeDep = Menu.lireString();
		Menu.afficheMsg("Quel est la ville d'arriv�e du Vol ?");
		String villeArr = Menu.lireString();
		Menu.afficheMsg("Quel est l'heure de d�part ?");
		GregorianCalendar hDep = this.lireDate("de d�part");
		Menu.afficheMsg("Quel est l'heure d'arriv�e ?");
		GregorianCalendar hArr = this.lireDate("d'arriv�e");
		Vol vol = new Vol(pil, av, villeDep, villeArr, hDep, hArr);
		volDao.create(vol);
		Menu.afficheMsg("Vol ajout� !");
		Connexion.afficheSelectEtoile("VOL", "numVol>0");
	}
	
	private void effectuerReadPilote() {
		Menu.afficheMsg("Quel num�ro de pilote cherchez-vous ?");
		int id = Menu.lireInt();
		Pilote pilote = new Pilote(null, null, 0);
		pilote.setNumPil(id);
		PiloteDAO piloteDao = PiloteDAO.getInstance();
		Menu.affichePil(pilote=piloteDao.read(id));;
		Connexion.fermer();
	}
	
	private void effectuerReadAvion() {
		Menu.afficheMsg("Quel num�ro d'avion cherchez-vous ?");
		int id = Menu.lireInt();
		Avion avion = new Avion(null, 0, null);
		avion.setNumAv(id);
		AvionDAO avionDao = AvionDAO.getInstance();
		Menu.afficheAv(avion=avionDao.read(id));;
		Connexion.fermer();
	}
	
	private void effectuerReadVol() {
		Menu.afficheMsg("Quel num�ro de vol cherchez-vous ?");
		int id = Menu.lireInt();
		Vol vol = new Vol(null, null, null, null, null, null) ;
		vol.setNumVol(id);
		VolDAO volDao = VolDAO.getInstance();
		Menu.afficheVol(vol=volDao.read(id));
		Connexion.fermer();
	}
	
	private void effectuerUpdatePilote() {
		Menu.afficheMsg("Num�ro du Pilote que vous souhaitez modifier :");
		int id = Menu.lireInt();
		Menu.afficheMsg("Nom :");
		String nomPil = Menu.lireString();
		Menu.afficheMsg("Adresse :");
		String adr = Menu.lireString();
		Menu.afficheMsg("Salaire :");
		int sal = Menu.lireInt();
		PiloteDAO piloteDao = PiloteDAO.getInstance();
		Pilote pilote = new Pilote(nomPil, adr, sal);
		pilote.setNumPil(id);
		Menu.afficheMsg("�tes vous s�r de vouloir modifier ce Pilote ?(o/n)");
		String rep = Menu.lireString();
		if (rep.equals("o")) {
			piloteDao.update(pilote);	
			Menu.afficheMsg("Pilote modifi� !");
			Connexion.afficheSelectEtoile("PILOTE", "numPil>0");
		}else {
			Menu.afficheMsg("Annulation");
		}
	}
	
	private void effectuerUpdateAvion() {
		Menu.afficheMsg("Num�ro de l'Avion que vous souhaitez modifier :");
		int id = Menu.lireInt();
		Menu.afficheMsg("D�nomination :");
		String nomAv = Menu.lireString();
		Menu.afficheMsg("Capacit� :");
		int capacite = Menu.lireInt();
		Menu.afficheMsg("Localisation :");
		String loc = Menu.lireString();
		AvionDAO avionDao = AvionDAO.getInstance();
		Avion avion = new Avion(nomAv, capacite, loc);
		avion.setNumAv(id);
		Menu.afficheMsg("�tes vous s�r de vouloir modifier cet Avion ?(o/n)");
		String rep = Menu.lireString();
		if (rep.equals("o")) {
			avionDao.update(avion);	
			Menu.afficheMsg("Avion modifi� !");
			Connexion.afficheSelectEtoile("AVION", "numAv>0");
		}else {
			Menu.afficheMsg("Annulation");
		}
	}
	
	private void effectuerUpdateVol() {
		Menu.afficheMsg("Num�ro du Vol que vous souhaitez modifier :");
		int id = Menu.lireInt();
		Menu.afficheMsg("Num�ro du Pilote pour ce Vol :");
		int idPil = Menu.lireInt();
		Pilote pil = new Pilote(null, null, 0);
		pil.setNumPil(idPil);
		Menu.afficheMsg("Num�ro de l'Avion pour ce Vol :");
		int idAv = Menu.lireInt();
		Avion av = new Avion(null, 0, null);
		av.setNumAv(idAv);
		Menu.afficheMsg("Ville de D�part de ce vol :");
		String villeDep = Menu.lireString();
		Menu.afficheMsg("Ville d'Arriv�e de ce vol :");
		String villeArr = Menu.lireString();
		Menu.afficheMsg("Heure de D�part de ce vol :");
		GregorianCalendar hDep = this.lireDate("de d�part");
		Menu.afficheMsg("Heure d'Arriv�e de ce vol :");
		GregorianCalendar hArr = this.lireDate("d'arriv�e");
		VolDAO volDao = VolDAO.getInstance();
		Vol vol = new Vol(pil, av, villeDep, villeArr, hDep, hArr);
		vol.setNumVol(id);
		Menu.afficheMsg("�tes vous s�r de vouloir modifier ce Vol ?(o/n)");
		String rep = Menu.lireString();
		if (rep.equals("o")) {
			volDao.update(vol);	
			Menu.afficheMsg("Vol modifi� !");
			Connexion.afficheSelectEtoile("VOL", "numVol>0");
		}else {
			Menu.afficheMsg("Annulation");
		}
	}
	
	/** Cette m�thode permet de lire une date
	 * 
	 * @param msg, un petit message permettant de savoir quelle date on entre
	 * @return une date au format Gregorian Calendar
	 */
	private GregorianCalendar lireDate(String msg){
		Menu.afficheMsg("Suivre les instructions ci-dessous pour la saisie de la date et l'heure "+msg);		
		String dateActuelle=""; 
		Menu.afficheMsg("quelle ann�e "+msg+" : "+dateActuelle);
		int annee = Menu.lireInt();
		dateActuelle+=annee+"/";
		Menu.afficheMsg("quelle mois "+msg+" : "+dateActuelle);
		int mois = Menu.lireInt();
		dateActuelle+=mois+"/";
		Menu.afficheMsg("quelle jour "+msg+" : "+dateActuelle);
		int jour = Menu.lireInt();
		dateActuelle+=jour+" ";
		Menu.afficheMsg("quelle heure "+msg+" : "+dateActuelle);
		int heure = Menu.lireInt();
		dateActuelle+=heure+":";
		Menu.afficheMsg("quelle minute "+msg+" : "+dateActuelle);
		int minute = Menu.lireInt();
		dateActuelle+=minute+":";
		Menu.afficheMsg("quelle seconde "+msg+" : "+dateActuelle);
		int seconde = Menu.lireInt();
		dateActuelle+=seconde;
		Menu.afficheMsg("date heure "+msg+" "+dateActuelle);		
		return new GregorianCalendar(annee, mois-1, jour, heure, minute, seconde);
	}

	/**
	 * M�thode d'interaction pour saisir les donn�es au clavier, cr�ation d'un Vol
	 * puis utilisation de create dans VolDAO pour �criture dans la table 
	 */
	private int gererMenuPpl() {
		int rep;
		Menu.afficheMsg("------------------------");
		Menu.afficheMsg("BIENVENUE");
		ArrayList<String> leMenu = new ArrayList<String>();
		leMenu.add("G�rer la table Pilote");
		leMenu.add("G�rer la table Avion");
		leMenu.add("G�rer la table Vol");
		switch (Menu.getChoix(leMenu)) {
		case 0:
			rep=MENU_TABLE_PILOTE;
			break;
		case 1:
			rep=MENU_TABLE_AVION;
			break;
		case 2:
			rep=MENU_TABLE_VOL;
			break;
		default:
			rep=-1;
			break;
		}
		return rep;
	}

}
