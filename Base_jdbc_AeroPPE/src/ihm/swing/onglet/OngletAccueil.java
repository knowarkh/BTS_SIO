package ihm.swing.onglet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.text.DateFormat;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OngletAccueil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JPanel CreerOngletAccueil() {
		JPanel onglet0 = new JPanel();
		onglet0.setLayout(new BorderLayout());
		//titre page accueil :
		JLabel jl0 = new JLabel("Bienvenue dans AeroBase");
		Font police = new Font("Tahoma", Font.BOLD, 16);
		jl0.setFont(police);
		jl0.setForeground(Color.blue);
		jl0.setHorizontalAlignment(JLabel.CENTER);

		//logo page accueil :
		ImageIcon imageLogo = new ImageIcon(new ImageIcon("src\\ihm\\swing\\logo-avion.png").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
		//C:\\Users\\admin\\git3\\Base_jdbc_Aeronautique\\src\\ihm\\swing\\logo-avion.png
		JLabel labImage = new JLabel(imageLogo);

		//afficher la date du jour dans l'onglet accueil :
		java.util.Date date =new java.util.Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
		JLabel jl = new JLabel(df.format(date));
		jl.setFont(police);
		jl.setForeground(Color.blue);
		jl.setHorizontalAlignment(JLabel.CENTER);

		//disposition onglet accueil :
		onglet0.add(jl0,BorderLayout.NORTH);
		onglet0.add(labImage,BorderLayout.CENTER);
		onglet0.add(jl, BorderLayout.SOUTH);
		return onglet0;
	}
}
