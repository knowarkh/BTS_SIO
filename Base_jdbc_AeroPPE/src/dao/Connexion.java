package dao;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

/**
 * étape 1 : la connexion à la base de données
 *
 */
public class Connexion {

	private static Connection connect = null;
	
//---Constantes---	
	private static final String ID = "arnaud";
	private static final String MDP = "sio";
	private static String NOM_SERVEUR = "BTSWIN7-99";
	private static final String NOM_BD = "aeronautiquePPE";

//---Constantes méthodes algo de présentation de requêtes console---
//	private static final int LARGEUR_COLONNE_TEXTE = 10;
//	private static final int LARGEUR_COLONNE_ENTIER = 6;
//	private static final int LARGEUR_COLONNE_DATE = 11;

	/**
	 * Patron de conception Singleton
	 * @return l'instance unique de connexion
	 */
	public static Connection getInstance() {
		if (connect==null) {
			// Si la connexion n'a pas encore été faite, on la fait.
			try { 

				//Si la connexion ne fonctionne pas mettre le try/catch en commentaire
                //Et définir la nom de serveur a la main dans les contante
                try {
                    NOM_SERVEUR = InetAddress.getLocalHost().getHostName();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
				SQLServerDataSource ds = new SQLServerDataSource();
				ds.setUser(ID);
				ds.setPassword(MDP);
				ds.setServerName(NOM_SERVEUR + "\\SQLEXPRESS");
				ds.setDatabaseName(NOM_BD);
				connect = ds.getConnection();
				System.out.println("---connecté---");
			}
			catch (SQLException e){
				System.out.println("Echec de la tentative de connexion : " + e.getMessage() + e.getStackTrace()) ;
			}
		}
		return connect;
	}

	/**
	 * Méthode statique d'exécution d'une requête de récupération de données
	 * @param requete
	 * @return resultset
	 */
	public static ResultSet executeQuery(String requete){
		Statement st = null ;
		ResultSet rs = null;
		//System.out.println("requete = "+requete);
		try{
			st = getInstance().createStatement() ;
			rs = st.executeQuery(requete) ;
		}catch(SQLException e){
			System.out.println("Echec de la tentative d'exécution de requete : " +requete + " ["+ e.getMessage()+"]") ;
		}
		return rs;
	}

	/**
	 * Une méthode statique qui permet de faire une mise à jour d'une table (INSERT / UPDATE / DELETE)
	 * Mais cette méthode n'est pas utilisée puisqu'on passe par des prepared statement
	 * dans les classes DAO et on fait des execute update directement sur ces preparedStatement.
	 * @param requete
	 * @return succes
	 */
	public static boolean executeUpdate(String requete){
		boolean succes = true;
		//System.out.println(requete);
		Statement st = null ;
		try{
			st = getInstance().createStatement() ;
			st.executeUpdate(requete) ;
		}catch(SQLException e){
			succes = false;
			System.out.println("Echec de la tentative d'exécution de Mise à Jour : " +requete + " ["+ e.getMessage()+"]") ;
		}
		return succes;
	}

	/**
	 * Fermeture de la connexion au SGBD SQL ServerExpress
	 */
	public static void fermer()
	{
		try
		{
			getInstance().close();
			System.out.println("---deconnexion ok---");
		}
		catch (SQLException e)
		{
			connect=null;
			System.out.println("echec de la fermeture");
		}
	}

	/**
	 * Requête qui permet de voir le contenu d'une table
	 * @param table
	 */
	public static void afficheSelectEtoile(String table, String clauseWhere){
		try{
			// Faire la requête SELECT FROM WHERE
			// l'exécuter pour obtenir un ResultSet (est une liste récupérant un élément à la fois)
			String requete = "SELECT * FROM " + table + " ;";
			if (clauseWhere!=null) {
				requete ="SELECT * FROM " + table + " WHERE " + clauseWhere + " ;";
			}
			//ResultSet rs = executeQuery("SELECT * FROM "+table+" WHERE "+clauseWhere+";");
			ResultSet rs = executeQuery(requete);
			ResultSetMetaData rsmetadata = rs.getMetaData();
			
			// récupérer un ResultSetMetaData les méta-données getMetaData()
			// parcourir le resultSet
			int nbCol = rsmetadata.getColumnCount();

			//System.out.println(rs.isBeforeFirst());
			//true
			//rs.next();
			
			//On se retrouve ici sur la première ligne 
			while (rs.next()) {
				for (int i = 1; i <= nbCol; i++)
				System.out.print(rsmetadata.getColumnName(i) + " " +rs.getString(i) + " ");
				System.out.println();
				}
				rs.close();
			
			//---Test affichage ResultSet---	
//			while(rs.next()) {
//				System.out.println(rs.getInt(1));
//			}
			
		}
		catch(SQLException e){
			System.out.println("Echec de la tentative d'interrogation Select * : " + e.getMessage()) ;
		}
	}


	/**
	 * Requête qui permet de récupérer le plus grand id de la table, a priori celui qui vient d'être affecté
	 * à une ligne créée via identity. Utiliser MAX
	 * @param cle
	 * @param table
	 * @return id
	 */
	public static int getMaxId(String cle, String table) {
		int id= -1;
		try {
			ResultSet rs = executeQuery("SELECT MAX ("+cle+") FROM "+table+";");
			while (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}


}
