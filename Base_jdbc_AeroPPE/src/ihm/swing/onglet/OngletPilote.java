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

import controleur.swing.CreatePilote;
import controleur.swing.DeletePilote;
import controleur.swing.UpdatePilote;
import dao.Connexion;
import ihm.swing.JTableRenderer;

public class OngletPilote extends JTabbedPane implements ActionListener {

	private static final long serialVersionUID = 1L;

	public static JPanel CreerOngletPilote() {
		JPanel jpanelTablePil = new JPanel(new BorderLayout());
		String sql2 = "SELECT COUNT(*) as nbLignes FROM PILOTE";
		ResultSet rs2 = Connexion.executeQuery(sql2);
		int nbLignes = 0;
		try {
			rs2.next();
			nbLignes = rs2.getInt("nbLignes");
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		String reqPil = "SELECT * FROM PILOTE;";
		ResultSet rsPil = Connexion.executeQuery(reqPil);
		String colonnes[] = {"Numéro Pilote", "Nom Pilote", "Adresse", "Salaire"};
		String dicoPil[][] = new String[nbLignes][4];
		int i = 0;
		try {
			while (rsPil.next()) {
				int numPil = rsPil.getInt("numPil");
				String nomPil = rsPil.getString("nomPil");
				String adr = rsPil.getString("adr");
				int sal = rsPil.getInt("sal");
				dicoPil[i][0] = String.valueOf(numPil);
				dicoPil[i][1] = nomPil;
				dicoPil[i][2] = adr;
				dicoPil[i][3] = String.valueOf(sal);
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DefaultTableModel model = new DefaultTableModel(dicoPil, colonnes);
		JTable table = new JTable(model);
		table.setShowGrid(true);
		table.setShowVerticalLines(true);
		table.setDefaultRenderer(Object.class, new JTableRenderer());
		table.setAutoCreateRowSorter(true);
		JScrollPane pane = new JScrollPane(table);
		jpanelTablePil.add(pane);
		return jpanelTablePil;
	}
	
	//boutons pied de page :
	public static JPanel creerBoutonPilote() {
		JButton rechercher = new JButton("Rechercher");
		JButton ajouter = new JButton("Ajouter");
		JButton supprimer = new JButton("Supprimer");
		JButton modifier = new JButton("Modifier");
		rechercher.setPreferredSize(new Dimension(150, 50));
		rechercher.setBorder(BorderFactory.createTitledBorder("Pilote"));
		ajouter.setPreferredSize(new Dimension(150, 50));
		ajouter.setBorder(BorderFactory.createTitledBorder("Pilote"));
		supprimer.setPreferredSize(new Dimension(150, 50));
		supprimer.setBorder(BorderFactory.createTitledBorder("Pilote"));
		modifier.setPreferredSize(new Dimension(150, 50));
		modifier.setBorder(BorderFactory.createTitledBorder("Pilote"));
		JPanel southPilote = new JPanel();
		southPilote.add(rechercher);
		southPilote.add(ajouter);
		southPilote.add(supprimer);
		southPilote.add(modifier);
		ActionListener alRecherche = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {	
				//à finaliser
				//new FindPilote();
			}
		};
		rechercher.addActionListener(alRecherche);
		ActionListener alAjouter = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				new CreatePilote();
			}
		};
		ajouter.addActionListener(alAjouter);
		ActionListener alSuppr = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				new DeletePilote();
			}
		};
		supprimer.addActionListener(alSuppr);
		ActionListener alModif = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				new UpdatePilote();
			}
		};
		modifier.addActionListener(alModif);
		return southPilote;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
