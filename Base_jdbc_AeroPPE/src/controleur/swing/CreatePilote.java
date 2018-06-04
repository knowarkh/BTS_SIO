package controleur.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.ControleurSwing;

public class CreatePilote extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final Dimension TAILLE_ECRAN = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private static final int HAUTEUR = (int)TAILLE_ECRAN.getHeight()/5;
	private static final int LARGEUR = (int)TAILLE_ECRAN.getWidth()*3/4;

	JTextField jtf = new JTextField();
	JTextField jtf1 = new JTextField();
	JTextField jtf2 = new JTextField();
	
	public CreatePilote() {
		super();
		this.setTitle("Ajouter un Pilote");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(LARGEUR,HAUTEUR);
		this.setLocationRelativeTo(null);
		JPanel container = new JPanel();
		JButton bouton = new JButton("OK");
		JLabel label = new JLabel("Nom du Pilote :");
		JLabel label1 = new JLabel("Adresse :");
		JLabel label2 = new JLabel("Salaire :");
		container.setLayout(new BorderLayout());
		JPanel pan = new JPanel();
		Font police = new Font("Tahoma", Font.BOLD, 14);
		jtf.setFont(police);
		jtf.setPreferredSize(new Dimension(150, 30));
		jtf1.setFont(police);
		jtf1.setPreferredSize(new Dimension(150, 30));
		jtf2.setFont(police);
		jtf2.setPreferredSize(new Dimension(150, 30));
		bouton.addActionListener(new BoutonListener());
		pan.add(label);
		pan.add(jtf);
		pan.add(label1);
		pan.add(jtf1);
		pan.add(label2);
		pan.add(jtf2);
		pan.add(bouton);
		container.add(pan);
		this.setContentPane(container);
		this.setVisible(true);
	}

	class BoutonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String nom = jtf.getText();
			String adr = jtf1.getText();
			int sal = Integer.parseInt(jtf2.getText());
			ControleurSwing.getInstance().creerPilote(nom, adr, sal);
			//fenêtre info
		}
	}
}
