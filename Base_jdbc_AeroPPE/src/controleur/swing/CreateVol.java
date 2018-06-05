package controleur.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controleur.ControleurSwing;
import ihm.swing.onglet.OngletVol;

public class CreateVol extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	public CreateVol() {
		setVisible(true);
		setTitle("Ajouter un Vol");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 540, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("N° du Pilote :");
		lblNewLabel.setBounds(10, 25, 105, 20);
		panel.add(lblNewLabel);
		textField = new JTextField();
		textField.setBounds(125, 20, 135, 30);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(125, 60, 135, 30);
		panel.add(textField_1);
		textField_1.setColumns(10);
		JLabel lblNewLabel_1 = new JLabel("N° de l'Avion :");
		lblNewLabel_1.setBounds(10, 65, 105, 25);
		panel.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("Ville de départ :");
		lblNewLabel_2.setBounds(10, 105, 105, 25);
		panel.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("Ville d'arrivée :");
		lblNewLabel_3.setBounds(10, 155, 105, 25);
		panel.add(lblNewLabel_3);
		JLabel lblNewLabel_4 = new JLabel("Heure de départ :");
		lblNewLabel_4.setBounds(10, 215, 105, 25);
		panel.add(lblNewLabel_4);
		JLabel lblNewLabel_5 = new JLabel("Heure d'arrivée :");
		lblNewLabel_5.setBounds(10, 265, 105, 25);
		panel.add(lblNewLabel_5);
		textField_2 = new JTextField();
		textField_2.setBounds(125, 105, 135, 30);
		panel.add(textField_2);
		textField_2.setColumns(10);	
		textField_3 = new JTextField();
		textField_3.setBounds(125, 155, 135, 30);
		panel.add(textField_3);
		textField_3.setColumns(10);
		textField_4 = new JTextField();
		textField_4.setBounds(125, 210, 135, 30);
		panel.add(textField_4);
		textField_4.setColumns(10);
		textField_5 = new JTextField();
		textField_5.setBounds(125, 260, 135, 30);
		panel.add(textField_5);
		textField_5.setColumns(10);
		JLabel lblNewLabel_6 = new JLabel("Format :");
		lblNewLabel_6.setBounds(300, 215, 85, 25);
		panel.add(lblNewLabel_6);
		textField_6 = new JTextField();
		textField_6.setText("16-02-2018 01:08:00");
		textField_6.setBounds(355, 210, 150, 30);
		panel.add(textField_6);
		JLabel lblNewLabel_7 = new JLabel("Format :");
		lblNewLabel_7.setBounds(300, 265, 50, 20);
		panel.add(lblNewLabel_7);
		textField_6.setColumns(10);
		textField_7 = new JTextField();
		textField_7.setText("16-02-2018 01:08:00");
		textField_7.setBounds(355, 260, 150, 30);
		panel.add(textField_7);
		textField_7.setColumns(10);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new BoutonListener(this));
		btnNewButton.setBounds(355, 65, 90, 25);
		panel.add(btnNewButton);
	}

	class BoutonListener implements ActionListener{
		CreateVol fenetre = null; 
		public BoutonListener(CreateVol createVol) {
			fenetre = createVol;
		}
		public void actionPerformed(ActionEvent e) {
			fenetre.dispose();
			int idPil = Integer.parseInt(textField.getText());
			int idAv = Integer.parseInt(textField_1.getText());
			String ville_Dep = textField_2.getText();
			String ville_Arr = textField_3.getText();
			String h_Dep = textField_4.getText();
			String h_Arr = textField_5.getText();
			ControleurSwing.getInstance().creerVol(idPil, idAv, ville_Dep, ville_Arr, h_Dep, h_Arr);
			OngletVol.getInstance().afficherSelect();
		}
	}
}
