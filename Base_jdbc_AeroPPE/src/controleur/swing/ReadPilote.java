package controleur.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controleur.ControleurSwing;
import dao.Connexion;

public class ReadPilote extends JFrame {

	private static final long serialVersionUID = 1L;

	JComboBox<Integer> combo = new JComboBox<Integer>();
	JPanel container = new JPanel();

	JButton b = new JButton("Valider");
	JLabel label = new JLabel("Quel numéro de Pilote cherchez-vous ?");

	public ReadPilote() {
		super();	
		this.setTitle("Rechercher un Pilote");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.WHITE);
		container.setLayout(new BorderLayout());
		JPanel top = new JPanel();
		top.add(label);
		this.remplirCombo();
		top.add(combo);
		top.add(b);
		container.add(top, BorderLayout.NORTH);
		this.setContentPane(container);
		b.addActionListener(new BoutonListener(this));
		pack();
		this.setVisible(true);
	}
	
	public void remplirCombo() {
		String reqPil = "SELECT numPil FROM PILOTE;";
		ResultSet rsPil = Connexion.executeQuery(reqPil);
		try {
			while (rsPil.next()) {
				int numPil = rsPil.getInt("numPil");
				combo.addItem(numPil);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	class BoutonListener implements ActionListener{
		ReadPilote fenetre = null; 
		public BoutonListener(ReadPilote readPil) {
			fenetre = readPil;
		}
		public void actionPerformed(ActionEvent e) {
			fenetre.dispose();
			int numPil = (int) combo.getSelectedItem();
			JOptionPane.showMessageDialog(null, "Pilote : " + ControleurSwing.getInstance().readAvion(numPil), "Résultat", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
