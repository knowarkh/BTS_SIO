package ihm.swing.onglet;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OngletAssist extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JPanel CreerOngletAssist() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JLabel commentlabel= new JLabel("Votre demande : ", JLabel.RIGHT);
		JTextArea commentTextArea = new JTextArea("Saisissez votre demande et nous vons répondrons dès que possible :", 10, 30);
		JScrollPane scrollPane = new JScrollPane(commentTextArea);    
		JButton showButton = new JButton("Envoyer");
		panel.add(commentlabel);
		panel.add(scrollPane);        
		panel.add(showButton);
		
		return panel;
	}
}
