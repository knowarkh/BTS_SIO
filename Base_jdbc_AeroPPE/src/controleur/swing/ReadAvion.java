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

public class ReadAvion extends JFrame {

	private static final long serialVersionUID = 1L;

	JComboBox<Integer> combo = new JComboBox<Integer>();
	JPanel container = new JPanel();

	JButton b = new JButton("Valider");
	JLabel label = new JLabel("Quel numéro d'Avion cherchez-vous ?");

	public ReadAvion() {
		super();	
		this.setTitle("Rechercher un Avion");
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
		String reqAv = "SELECT numAv FROM AVION;";
		ResultSet rsAv = Connexion.executeQuery(reqAv);
		try {
			while (rsAv.next()) {
				int numAv = rsAv.getInt("numAv");
				combo.addItem(numAv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	class BoutonListener implements ActionListener{
		ReadAvion fenetre = null; 
		public BoutonListener(ReadAvion readAv) {
			fenetre = readAv;
		}
		public void actionPerformed(ActionEvent e) {
			fenetre.dispose();
			int numAv = (int) combo.getSelectedItem();
			JOptionPane.showMessageDialog(null, "Avion : " + ControleurSwing.getInstance().readAvion(numAv), "Résultat", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
