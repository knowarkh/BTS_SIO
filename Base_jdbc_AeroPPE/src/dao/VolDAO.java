package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

import aeronautique.Vol;

/**
 * étape 2 : le patron de conception DAO, le lien vers notre table PILOTE
 * On étend la classe DAO avec un Pilote
 * @author abi
 *
 */
public class VolDAO extends DAO<Vol> {

	//---2 constantes de classe : le nom de la table, la clé primaire---
	
	private static final String TABLE="Vol";
	private static final String CLE_PRIM="numVol";

	/* !!! DATES : pour les bases de données, on passera par java.sql.Timestamp 
	 * Pour le find :
	 * GregorianCalendar hArr = new GregorianCalendar();
	 * hArr.setTimeInMillis (rs.getTimestamp("harr").getTime());
	 * Pour le create :
	 * Timestamp ts = new Timestamp (vol.gethDep().getTimeInMillis());
	 * pst.setTimestamp(3,ts);
	 * 
	 * NB : les mois dans le constructeur de Gregorian Calendar vont de 0 à 11.
	 * 
	 * En utilisant SimpleDateFormat, on peut avoir un affichage avec des termes français.
	 * SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy zzzz G", Locale.FRENCH);
	 * 
	 */

	
	//---Pattern singleton (instance unique de VolDAO)---
	//---Constante singleton---
	private static VolDAO instance = null;
	//---Méthode getInstance---
	public static VolDAO getInstance() {
		if (instance==null) {
			instance = new VolDAO();		
		}
		return instance;
	}
	//---Constructeur---
	private VolDAO() {
		super();
	}

	
	/**
	 * On donne un vol en entrée qu'on va écrire dans la base de données
	 */
	@Override
	public boolean create(Vol obj) {
		PreparedStatement pst = null;
		boolean succes=true;
		try {
			String req = "INSERT INTO "+TABLE+" (numPil,numAV,villeDep,villeArr,hDep,hArr) VALUES(?,?,?,?,?,?);";
			pst = Connexion.getInstance().prepareStatement(req);
			pst.setInt(1, obj.getPilote().getNumPil());
			pst.setInt(2, obj.getAvion().getNumAv());
			pst.setString(3, obj.getVilleDep());
			pst.setString(4, obj.getVilleArr());
			Timestamp ts1 = new Timestamp (obj.gethDep().getTimeInMillis());
			pst.setTimestamp(5, ts1);
			Timestamp ts2 = new Timestamp (obj.gethArr().getTimeInMillis());
			pst.setTimestamp(6, ts2);
			pst.executeUpdate();
			pst.close();
			// Ensuite, il faut remettre à jour l'identifiant de l'objet java,
			// généré automatiquement par la base de données
			int maxId = Connexion.getMaxId(CLE_PRIM, TABLE);
			obj.setNumVol(maxId);

			put(maxId, obj);
			
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	/**
	 * On donne un vol en entrée qu'on va supprimer de la base de données
	 */
	@Override
	public boolean delete(Vol obj) {
		boolean succes=true;
		int id = obj.getNumVol();
		PreparedStatement pst = null;
		try {
			String req = "DELETE FROM "+TABLE+" WHERE "+CLE_PRIM+" = ?;";
			pst = Connexion.getInstance().prepareStatement(req);
			pst.setInt(1, id);
			pst.executeUpdate();
			pst.close();
			
			remove(id);

		} catch (SQLException e) {
			succes = false;
			e.printStackTrace();
		} 
		return succes;		
	}

	/**
	 * On donne un vol en entrée qu'on va mettre à jour dans la base de données
	 */
	@Override
	public boolean update(Vol obj) {
		boolean succes=true;
		PreparedStatement pst = null;
		int id = obj.getNumVol();
		try {
			// requete, preparedStatement, setInt, setString, setTimeStamp etc. puis executeUpdate
			String req = "UPDATE "+TABLE+" SET numPil = ?, numAv = ?, villeDep = ?, villeArr = ?, hDep = ?, hArr = ? WHERE "+CLE_PRIM+" = ?;";
			pst = Connexion.getInstance().prepareStatement(req);
			pst.setInt(1, obj.getPilote().getNumPil());
			pst.setInt(2, obj.getAvion().getNumAv());
			pst.setString(3, obj.getVilleDep());
			pst.setString(4, obj.getVilleArr());
			Timestamp ts1 = new Timestamp (obj.gethDep().getTimeInMillis());
			pst.setTimestamp(5, ts1);
			Timestamp ts2 = new Timestamp (obj.gethArr().getTimeInMillis());
			pst.setTimestamp(6, ts2);
			pst.setInt(7, id);
			pst.executeUpdate();
			pst.close();

		} catch (SQLException e) {
			succes = false;
			e.printStackTrace();
		} 
		return succes;	
	}

	/**
	 * On donne un identifiant entier en entrée qu'on cherche dans la base de données
	 */
	@Override
	public Vol read(int id) {
		Vol vol = null;
		if (countains(id)) {
			vol = get(id);
		}
		else {
			try {
				String req = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIM+" = "+id+";";
				ResultSet rs = Connexion.executeQuery(req);
				rs.isBeforeFirst();
				while (rs.next()) {
					GregorianCalendar hDep = new GregorianCalendar();
					hDep.setTimeInMillis (rs.getTimestamp("hDep").getTime());
					GregorianCalendar hArr = new GregorianCalendar();
					hArr.setTimeInMillis (rs.getTimestamp("harr").getTime());
					int numPil = rs.getInt(2);
					//new PiloteDAO().find(numPil);
					int numAv = rs.getInt(3);
					//new AvionDAO().find(numAv);
					vol = new Vol(PiloteDAO.getInstance().read(numPil),	
						AvionDAO.getInstance().read(numAv),
						rs.getString(4), 
						rs.getString(5), 
						hDep, 
						hArr);
					vol.setNumVol(rs.getInt(1));
				}
				rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vol;
	}

}
