package ihm.swing;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuAero extends JMenuBar {
	
	private static final long serialVersionUID = 1L;

	public MenuAero() {
		
		//A revoir
		//---3 Menus principaux---
		JMenu menu1 = new JMenu("Fichier");
		this.add(menu1);
		JMenu menu2 = new JMenu("Edition");
		this.add(menu2);
		JMenu menu3 = new JMenu("Outils");
		this.add(menu3);
		JMenu menu4 = new JMenu("?");
		this.add(menu4);

		//---Groupe 1 JMenuItems---
		JMenuItem menuItem1 = new JMenuItem("Ouvrir");
		menu1.add(menuItem1);
		JMenuItem menuItem2 = new JMenuItem("Enregistrer sous...");
		menu1.add(menuItem2);
		JMenuItem menuItem3 = new JMenuItem("Mise en page");
		menu1.add(menuItem3);
		JMenuItem menuItem4 = new JMenuItem("Quitter");
		menu1.add(menuItem4);
		
		//---Groupe 2 JMenuItems---
		JMenuItem menuItem5 = new JMenuItem("Annuler");
		menuItem5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_MASK));
		menu2.add(menuItem5);
		JMenuItem menuItem6 = new JMenuItem("Couper");
		menuItem6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK));
		menu2.add(menuItem6);
		JMenuItem menuItem7 = new JMenuItem("Copier");
		menuItem7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
		menu2.add(menuItem7);
		JMenuItem menuItem8 = new JMenuItem("Coller");
		menuItem8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK));
		menu2.add(menuItem8);
//		JMenuItem menuItem9 = new JMenuItem("Supprimer");
//		menuItem9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE));
//		menu2.add(menuItem9);
		JMenuItem menuItem10 = new JMenuItem("Rechercher");
		menuItem10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK));
		menu2.add(menuItem10);
		JMenuItem menuItem11 = new JMenuItem("Tout sélectionner");
		menuItem11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
		menu2.add(menuItem11);

		//---Groupe 3 JMenuItems---
		JMenuItem menuItem12 = new JMenuItem("Outils AeroBase");
		menu3.add(menuItem12);
		menu3.addSeparator();
		JMenu sousmenu = new JMenu("Options...");
		JMenuItem mI1 = new JMenuItem("Option 1");
		sousmenu.add(mI1);
		JMenuItem mI2 = new JMenuItem("Option 2");
		sousmenu.add(mI2);
		menu3.add(sousmenu);
		
		//---Groupe 4 JMenuItems---
		JMenuItem menuItem14 = new JMenuItem("Aide");
		menu4.add(menuItem14);
		JMenuItem menuItem15 = new JMenuItem("A propos de...");
		menu4.add(menuItem15);
	}
}
