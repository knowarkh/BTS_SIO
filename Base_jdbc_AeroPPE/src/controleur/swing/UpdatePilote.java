package controleur.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controleur.ControleurSwing;
import ihm.swing.onglet.OngletPilote;

public class UpdatePilote extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public UpdatePilote() {
		setTitle("Modifier un Pilote");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 476, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Num�ro :");
		lblNewLabel.setBounds(25, 50, 105, 25);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nom du Pilote :");
		lblNewLabel_1.setBounds(25, 100, 105, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Adresse :");
		lblNewLabel_2.setBounds(25, 150, 105, 25);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Salaire :");
		lblNewLabel_3.setBounds(25, 200, 105, 25);
		contentPane.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBounds(175, 50, 150, 25);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(175, 100, 150, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(175, 150, 150, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(175, 200, 150, 25);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("Mettre � jour");
		btnNewButton.addActionListener(new BoutonListener(this));
		btnNewButton.setBounds(170, 250, 130, 25);
		contentPane.add(btnNewButton);
		this.setVisible(true);
	}
	class BoutonListener implements ActionListener{
		UpdatePilote fenetre = null; 
		public BoutonListener(UpdatePilote updatePilote) {
			fenetre = updatePilote;
		}
		public void actionPerformed(ActionEvent e) {
			fenetre.dispose();
			int id = Integer.parseInt(textField.getText());
			String nom = textField_1.getText();
			String adr = textField_2.getText();			
			int sal = Integer.parseInt(textField_3.getText());
			ControleurSwing.getInstance().updPilote(id, nom, adr, sal);
			OngletPilote.getInstance().afficherSelect();
		}
	}

}
