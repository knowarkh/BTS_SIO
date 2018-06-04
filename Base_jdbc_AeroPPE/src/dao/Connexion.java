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
 * �tape 1 : la connexion � la base de donn�es
 *
 */
public class Connexion {

	private static Connection connect = null;
	
//---Constantes---	
	private static final String ID = "arnaud";
	private static final String MDP = "sio";
	private static String NOM_SERVEUR = "BTSWIN7-99";
	private static final String NOM_BD = "aeronautiquePPE";

//---Constantes m�thodes algo de pr�sentation de requ�tes console---
//	private static final int LARGEUR_COLONNE_TEXTE = 10;
//	private static final int LARGEUR_COLONNE_ENTIER = 6;
//	private static final int LARGEUR_COLONNE_DATE = 11;

	/**
	 * Patron de conception Singleton
	 * @return l'instance unique de connexion
	 */
	public static Connection getInstance() {
		if (connect==null) {
			// Si la connexion n'a pas encore �t� faite, on la fait.
			try { 

				//Si la connexion ne fonctionne pas mettre le try/catch en commentaire
                //Et d�finir la nom de serveur a la main dans les contante
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
				System.out.println("---connect�---");
			}
			catch (SQLException e){
				System.out.println("Echec de la tentative de connexion : " + e.getMessage() + e.getStackTrace()) ;
			}
		}
		return connect;
	}

	/**
	 * M�thode statique d'ex�cution d'une requ�te de r�cup�ration de donn�es
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
			System.out.println("Echec de la tentative d'ex�cution de requete : " +requete + " ["+ e.getMessage()+"]") ;
		}
		return rs;
	}

	/**
	 * Une m�thode statique qui permet de faire une mise � jour d'une table (INSERT / UPDATE / DELETE)
	 * Mais cette m�thode n'est pas utilis�e puisqu'on passe par des prepared statement
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
			System.out.println("Echec de la tentative d'ex�cution de Mise � Jour : " +requete + " ["+ e.getMessage()+"]") ;
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
	 * Requ�te qui permet de voir le contenu d'une table
	 * @param table
	 */
	public static void afficheSelectEtoile(String table, String clauseWhere){
		try{
			// Faire la requ�te SELECT FROM WHERE
			// l'ex�cuter pour obtenir un ResultSet (est une liste r�cup�rant un �l�ment � la fois)
			String requete = "SELECT * FROM " + table + " ;";
			if (clauseWhere!=null) {
				requete ="SELECT * FROM " + table + " WHERE " + clauseWhere + " ;";
			}
			//ResultSet rs = executeQuery("SELECT * FROM "+table+" WHERE "+clauseWhere+";");
			ResultSet rs = executeQuery(requete);
			ResultSetMetaData rsmetadata = rs.getMetaData();
			
			// r�cup�rer un ResultSetMetaData les m�ta-donn�es getMetaData()
			// parcourir le resultSet
			int nbCol = rsmetadata.getColumnCount();

			//System.out.println(rs.isBeforeFirst());
			//true
			//rs.next();
			
			//On se retrouve ici sur la premi�re ligne 
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
	 * Requ�te qui permet de r�cup�rer le plus grand id de la table, a priori celui qui vient d'�tre affect�
	 * � une ligne cr��e via identity. Utiliser MAX
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
