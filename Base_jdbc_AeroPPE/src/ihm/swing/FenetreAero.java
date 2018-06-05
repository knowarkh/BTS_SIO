package ihm.swing;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import ihm.swing.onglet.OngletAccueil;
import ihm.swing.onglet.OngletAssist;
import ihm.swing.onglet.OngletAvion;
import ihm.swing.onglet.OngletPilote;
import ihm.swing.onglet.OngletVol;

//implements ActionListener pour les boutons
public class FenetreAero extends JFrame {
	
	//static JPanel onglet1 = new JPanel();
	private static final long serialVersionUID = 1L;

	//DefaultToolkit pour récupérer des infos sur la config : 
	private static final Dimension TAILLE_ECRAN = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private static final int HAUTEUR = (int)TAILLE_ECRAN.getHeight()*3/4;
	private static final int LARGEUR = (int)TAILLE_ECRAN.getWidth()*3/4;
	
	
	public FenetreAero() {
		super("AeroBase v1.0");
		//Ici on crée un nouvel objet et on extends directement la class en faisant comme un overide après les crochets :
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		addWindowListener(l);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(LARGEUR,HAUTEUR);
		setLocationRelativeTo(null);
		setVisible(true);

		//Barre de menu :
		this.setJMenuBar(new MenuAero());
		
		//Icone du programme :
		Image iconAvion = Toolkit.getDefaultToolkit().getImage("src\\ihm\\swing\\logo.jpg");
//		C:\\Users\\admin\\git3\\Base_jdbc_Aeronautique\\src\\ihm\\swing\\logo.jpg
		this.setIconImage(iconAvion);

		//accrochage des onglets :
		JTabbedPane onglets = new JTabbedPane(SwingConstants.LEFT);
		
		//onglet Accueil :
		onglets.addTab("ACCUEIL", OngletAccueil.CreerOngletAccueil());
		
		//onglet Avion :
		onglets.addTab("AVION", OngletAvion.getInstance());
		
		//onglet Pilote :
		onglets.addTab("PILOTE", OngletPilote.getInstance());

		//onglet Vol :
		onglets.addTab("VOL", OngletVol.getInstance());
		
		//onglet statistiques : requêtes à faire
//		JPanel ongletStats = new JPanel();
//		ongletStats.setLayout(new BorderLayout());
//		JLabel temp = new JLabel("En cours de développement");
//		temp.setHorizontalAlignment(JLabel.CENTER);
//		ongletStats.add(temp, BorderLayout.NORTH);
//		onglets.addTab("STATISTIQUES", ongletStats);
		
		//onglet assistance :
		onglets.addTab("ASSISTANCE", OngletAssist.CreerOngletAssist());

		onglets.setOpaque(true);
		this.add(onglets);
		this.setVisible(true);
	}

}
