package aeronautique;

import javax.swing.JOptionPane;

import controleur.Controleur;
import dao.Connexion;
import ihm.swing.FenetreAero;
import test.Initialisation;


/**
 * 
 * @author abi
 * @author aco
 *
 */
public class Principale {
	//Passer la constante INIT � true pour lancer les scripts de cr�ation de tables
	static boolean INIT = false;
	
	//bonjour
	public static void main(String[] args) {
		
		if(INIT){
			Initialisation.initialisation();
		}
		choixIhm();
	}

	private static void choixIhm() {
		int option = JOptionPane.showConfirmDialog(null, "Voulez-vous acc�der � l'interface graphique ?", "IHM", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(option == JOptionPane.YES_OPTION) {
			new FenetreAero();
		}
		else if(option == JOptionPane.NO_OPTION) {
			new Controleur();
			Connexion.fermer();
		}
		else if(option == JOptionPane.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "Vous avez annul� l'op�ration.", "Annulation", JOptionPane.PLAIN_MESSAGE);
		}
		else if(option == JOptionPane.CLOSED_OPTION) {
			System.out.println("fermer");
		}
		else {
			System.out.println("option impossible");
		}
	}
}
