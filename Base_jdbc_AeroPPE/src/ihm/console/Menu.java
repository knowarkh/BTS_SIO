package ihm.console;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;

import aeronautique.Avion;
import aeronautique.Pilote;
import aeronautique.Vol;

public class Menu {
	
	private static Scanner sc = null;

	private static Scanner getInstance() {
		if (sc == null) {
			sc = new Scanner(System.in); 
		}
		return sc;
	}

	public static void fermer() {
		sc.close();
		sc=null;
	}

	
	public Menu() {
		super();
	}

	/**
	 * Base des menus de la console
	 * @param lignes contient une liste de chaines de caractères pour avoir le nombre de choix
	 * @return le choix de l'utilisateur
	 */
	public static int getChoix(ArrayList<String> lignes){
		int nbChoix=lignes.size();
		int choix=0;

		try{
			// L'instruction try/catch permet de gérer les fonctionnements anormaux d'une application.
			// Le corps du try correspond au fonctionnement normal

			System.out.println("------------------------");
			for (int i = 0; i < nbChoix; i++) {
				System.out.println(i+" : "+lignes.get(i));
			}
			System.out.println(nbChoix+" : Quitter");
			System.out.println("------------------------");
			do{
				System.out.println("saisissez votre choix");
				choix = lireInt();
			}while (choix<0 || choix>nbChoix);

		}catch(InputMismatchException e) {
			// Le corps du catch correspond au fonctionnement anormal : l'exception qui a été détectée
			// ici : InputMismatchException = il est possible que le caractère frappé au clavier ne soit pas un entier.
			// Dans ce cas, on demande une nouvelle saisie.
			System.out.println("choix non possible");
			getInstance().nextLine();
			return Menu.getChoix(lignes);
		}
		if (choix==nbChoix) {
			choix = -1;
		}
		return choix;
	}
		
	/**
	 * Affiche simplement un message dans la console
	 * @param msg contient le message à afficher
	 */
	public static void afficheMsg(String msg){
		System.out.println(msg);
	}
	
	public static void affichePil(Pilote pilote) {
		System.out.println(pilote);
	}
	
	public static void afficheAv(Avion avion) {
		System.out.println(avion);
	}
	
	public static void afficheVol(Vol vol) {
		System.out.println(vol);
	}
	
	/**
	 * Méthode permettant d'afficher un message via une msgbox
	 * @param titre le titre de la fenetre (box)
	 * @param msg le message contenu dans la fenetre (box)
	 */
	public static void affMsgBox(String titre, String msg) {
		JFrame frame = new JFrame(titre);
		new Msgbox(frame, msg);
	}

	/**
	 * Permet de lire un entier frappé au clavier
	 * @return un entier lu
	 */
	public static int lireInt() {
		int rep = getInstance().nextInt();
		getInstance().nextLine(); // manger le retour à la ligne
		return rep;
	}

	/**
	 * Permet de lire une chaine de caractères frappée au clavier
	 * @return une chaine lue
	 */
	public static String lireString(){
		String rep = getInstance().nextLine();
		return rep;
	}

	
}
