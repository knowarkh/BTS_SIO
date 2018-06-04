package controleur.swing;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class DeletePilote extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final Dimension TAILLE_ECRAN = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private static final int HAUTEUR = (int)TAILLE_ECRAN.getHeight()/5;
	private static final int LARGEUR = (int)TAILLE_ECRAN.getWidth()*3/4;

	JTextField jtf = new JTextField();
	
	JPanel container = new JPanel();
	JButton b = new JButton("OK");
	JLabel label = new JLabel("Numéro du Pilote à supprimer :");

	public DeletePilote() {
		super();
		this.setTitle("Supprimer un Pilote");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(LARGEUR,HAUTEUR);
		this.setLocationRelativeTo(null);
		
		container.setBackground(Color.WHITE);
		container.setLayout(new BorderLayout());
		JPanel top = new JPanel();
		Font police = new Font("Tahoma", Font.BOLD, 14);
		jtf.setFont(police);
		jtf.setPreferredSize(new Dimension(150, 30));
		b.addActionListener(new BoutonListener());
		top.add(label);
		top.add(jtf);
		top.add(b);
		container.add(top, BorderLayout.NORTH);
		this.setContentPane(container);
		pack();
		this.setVisible(true);

	}
	class BoutonListener implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	      int f = Integer.parseInt(jtf.getText());
	      ControleurSwing.getInstance().delPilote(f);
	    }
	  }
}
