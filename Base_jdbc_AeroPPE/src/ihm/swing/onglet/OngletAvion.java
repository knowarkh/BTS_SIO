package ihm.swing.onglet;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.swing.CreateAvion;
import controleur.swing.DeleteAvion;
import controleur.swing.UpdateAvion;
import dao.Connexion;
import ihm.swing.JTableRenderer;

public class OngletAvion extends JTabbedPane implements ActionListener {

	private static final long serialVersionUID = 1L;

	public static JPanel CreerOngletAvion() {
		JPanel jpanelTableAv = new JPanel(new BorderLayout());
		jpanelTableAv.add(panelOngletAvion(jpanelTableAv));		
		return jpanelTableAv;
	}
	
	//---Méthodes à créer dans la DAO pour ne pas avoir de requetes ici---
	private static JScrollPane panelOngletAvion(JPanel jpanelTableAv) {
		String sql1 = "SELECT COUNT(*) as nbLignes FROM AVION";
		ResultSet rs1 = Connexion.executeQuery(sql1);
		int nbLignes = 0;
		try {
			rs1.next();
			nbLignes = rs1.getInt("nbLignes");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String reqAV = "SELECT * FROM AVION;";
		ResultSet rsAv = Connexion.executeQuery(reqAV);
		String colonnes[] = {"Numéro Avion", "Nom Avion", "Capacité","Localisation"};

		//Creation d'un dictionnaire :
		String dicoAv[][] = new String[nbLignes][4];
		int i = 0;
		try {
			while (rsAv.next()) {
				int numAV = rsAv.getInt("numAV");
				String nomAv = rsAv.getString("nomAv");
				int capacite = rsAv.getInt("capacite");
				String Loc = rsAv.getString("Loc");
				dicoAv[i][0] = String.valueOf(numAV);
				dicoAv[i][1] = nomAv;
				dicoAv[i][2] = String.valueOf(capacite);
				dicoAv[i][3] = Loc;
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DefaultTableModel model = new DefaultTableModel(dicoAv, colonnes);
		JTable table = new JTable(model);
		table.setShowGrid(true);
		table.setShowVerticalLines(true);
		table.setDefaultRenderer(Object.class, new JTableRenderer());
		table.setAutoCreateRowSorter(true);
		JScrollPane pane = new JScrollPane(table);
		return pane;
	}

	//Boutons pied de page :
	public static JPanel creerBoutonAvion() {
		JButton rechercher = new JButton("Rechercher");
		JButton ajouter = new JButton("Ajouter");
		JButton supprimer = new JButton("Supprimer");
		JButton modifier = new JButton("Modifier");
		rechercher.setPreferredSize(new Dimension(150, 50));
		rechercher.setBorder(BorderFactory.createTitledBorder("Avion"));
		ajouter.setPreferredSize(new Dimension(150, 50));
		ajouter.setBorder(BorderFactory.createTitledBorder("Avion"));
		supprimer.setPreferredSize(new Dimension(150, 50));
		supprimer.setBorder(BorderFactory.createTitledBorder("Avion"));
		modifier.setPreferredSize(new Dimension(150, 50));
		modifier.setBorder(BorderFactory.createTitledBorder("Avion"));
		JPanel southAvion = new JPanel();
		southAvion.add(rechercher);
		southAvion.add(ajouter);
		southAvion.add(supprimer);
		southAvion.add(modifier);
		ActionListener alRecherche = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {	
				//à finaliser
				//new FindAvion();
			}
		};
		rechercher.addActionListener(alRecherche);
		ActionListener alAjouter = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				new CreateAvion();
			}
		};
		ajouter.addActionListener(alAjouter);
		ActionListener alSuppr = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				new DeleteAvion();
			}
		};
		supprimer.addActionListener(alSuppr);
		ActionListener alModif = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				new UpdateAvion();
			}
		};
		modifier.addActionListener(alModif);
		return southAvion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}


