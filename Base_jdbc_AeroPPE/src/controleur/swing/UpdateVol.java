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

public class UpdateVol extends JFrame {

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
	private JTextField textField_8;
	
	public UpdateVol() {
		setTitle("Modifier un Vol");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("N° du Vol :");
		lblNewLabel.setBounds(40, 20, 90, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("N° du Pilote :");
		lblNewLabel_1.setBounds(40, 70, 90, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("N° de l'Avion :");
		lblNewLabel_2.setBounds(40, 120, 90, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ville de départ :");
		lblNewLabel_3.setBounds(40, 165, 90, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ville d'arrivée :");
		lblNewLabel_4.setBounds(40, 210, 90, 35);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Heure de départ");
		lblNewLabel_5.setBounds(40, 260, 90, 35);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Heure d'arrivée");
		lblNewLabel_6.setBounds(40, 305, 90, 35);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(210, 25, 125, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(210, 70, 125, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(210, 120, 125, 35);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(210, 165, 125, 35);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(210, 210, 125, 35);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(210, 260, 125, 35);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(210, 305, 125, 35);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Format :");
		lblNewLabel_7.setBounds(370, 270, 70, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Format :");
		lblNewLabel_8.setBounds(370, 315, 70, 15);
		contentPane.add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		textField_7.setText("16-02-2018 01:08:00");
		textField_7.setBounds(450, 265, 135, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setText("16-02-2018 01:08:00");
		textField_8.setBounds(450, 315, 135, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton = new JButton("Mettre à jour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textField.getText());
				int idPil = Integer.parseInt(textField_1.getText());
				int idAv = Integer.parseInt(textField_2.getText());
				String ville_Dep = textField_3.getText();
				String ville_Arr = textField_4.getText();
				String h_Dep = textField_5.getText();
				String h_Arr = textField_6.getText();
				ControleurSwing.getInstance().updVol(id, idPil, idAv, ville_Dep, ville_Arr, h_Dep, h_Arr);
			}
		});
		btnNewButton.setBounds(105, 380, 135, 25);
		contentPane.add(btnNewButton);
		this.setVisible(true);
	}
}
