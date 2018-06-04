package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aeronautique.Avion;

public class AvionDAO extends DAO<Avion> {
	
	//---2 constantes de classe---
	private static final String TABLE="Avion";
	private static final String CLE_PRIM="numAv";
	
	
	//---Pattern singleton (instance unique de AvionDAO)---
	//---constante singleton---
	private static AvionDAO instance = null;
	//---méthode getInstance---
	public static AvionDAO getInstance() {
		if (instance==null) {
			instance = new AvionDAO();		
		}
		return instance;
	}
	//---Constructeur---
	private AvionDAO() {
		super();
	}

	
	//---Méthodes CRUD---
	@Override
	public boolean create(Avion obj) {
		PreparedStatement pst = null;
		boolean succes=true;
		try {
			//---Le prepared Statement prépare notre requete puis on utilise executeUpdate---
			String req = "INSERT INTO "+TABLE+" (nomAv,capacite,loc) VALUES(?,?,?);";
			pst = Connexion.getInstance().prepareStatement(req);
			pst.setString(1, obj.getNomAv());
			pst.setInt(2, obj.getCapacite());
			pst.setString(3, obj.getLoc());
			pst.executeUpdate();
			pst.close();
			//---Ensuite, il faut remettre à jour l'identifiant de l'objet java,
			// généré automatiquement par la base de données---
			int maxId = Connexion.getMaxId(CLE_PRIM, TABLE);
			obj.setNumAv(maxId);
			
			put(maxId, obj);

		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean delete(Avion obj) {
		boolean succes=true;
		int id = obj.getNumAv();
		PreparedStatement pst = null;
		try {
			//---Prepared Statement et executeUpdate---
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

	@Override
	public boolean update(Avion obj) {
		boolean succes=true;
		PreparedStatement pst = null;
		int id = obj.getNumAv();
		try {
			//---requete, preparedStatement, setInt, setString, setTimeStamp etc. puis executeUpdate---
			String req = "UPDATE "+TABLE+" SET nomAv = ?, capacite = ?, loc = ? WHERE "+CLE_PRIM+" = ?;";
			pst = Connexion.getInstance().prepareStatement(req);
			pst.setString(1, obj.getNomAv());
			pst.setInt(2, obj.getCapacite());
			pst.setString(3, obj.getLoc());
			pst.setInt(4, id);
			pst.executeUpdate();
			pst.close();

		} catch (SQLException e) {
			succes = false;
			e.printStackTrace();
		} 
		return succes;	
	}

	@Override
	public Avion read(int id) {
		Avion avion = null;
		if (countains(id)) {
			avion = get(id);
		}
		else {
			try {
				String req = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIM+" = "+id+";";
				ResultSet rs = Connexion.executeQuery(req);
				rs.isBeforeFirst();
				while (rs.next()) {
					avion = new Avion(
							rs.getString(2), 
							rs.getInt(3),
							rs.getString(4));
					avion.setNumAv(rs.getInt(1));
				}
				rs.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return avion;
	}

}
