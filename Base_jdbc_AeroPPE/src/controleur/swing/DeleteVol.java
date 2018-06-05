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
import ihm.swing.onglet.OngletVol;

public class DeleteVol extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel container = new JPanel();
	JButton b = new JButton("OK");
	JTextField jtf = new JTextField();
	JLabel label = new JLabel("Numéro du Vol à supprimer");

	public DeleteVol() {
		super();

		this.setTitle("Supprimer un Vol");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.WHITE);
		container.setLayout(new BorderLayout());
		JPanel top = new JPanel();
		Font police = new Font("Tahoma", Font.BOLD, 14);
		jtf.setFont(police);
		jtf.setPreferredSize(new Dimension(150, 30));
		b.addActionListener(new BoutonListener(this));
		top.add(label);
		top.add(jtf);
		top.add(b);
		container.add(top, BorderLayout.NORTH);
		this.setContentPane(container);
		pack();
		this.setVisible(true);

	}
	class BoutonListener implements ActionListener{
		DeleteVol fenetre = null; 
		public BoutonListener(DeleteVol deleteVol) {
			fenetre = deleteVol;
		}
	    public void actionPerformed(ActionEvent e) {
	    	fenetre.dispose();
	      int id = Integer.parseInt(jtf.getText());
	      ControleurSwing.getInstance().delVol(id);
	      OngletVol.getInstance().afficherSelect();
	    }
	  }
}
