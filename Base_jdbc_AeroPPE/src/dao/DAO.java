package dao;

import java.util.HashMap;

/**
 * le patron de conception DAO
 * @param <T> pour s�rialisation d'objets de type T
 */
public abstract class DAO<T> {
	
	//Cr�ation HashMap pour �viter le probl�me des ref crois�es et avoir 1 seul obj en m�moire :
	//associe un entier (cl�) et un objet
	private final HashMap <Integer, T> hmap = new HashMap<Integer, T>();
	
	//Red�finition des m�thodes HashMap (pour �viter un extends) :
	protected boolean countains (int id) {
		return hmap.containsKey(id);
	}
	
	protected T put (int id, T obj) {
		return hmap.put(id, obj);
	}
	
	protected T get (int id) {
		return hmap.get(id);
	}
	
	protected T remove (int id) {
		return hmap.remove(id);
	}
	
	
	/**
	 * M�thode de cr�ation d'un objet de type "T",
	 * peut �tre amen� � injecter l'id cr�� dans le programme
	 * @param obj
	 * @return boolean 
	 */
	public abstract boolean create(T obj);

	/**
	 * M�thode pour effacer selon l'id de l'objet
	 * @param obj
	 * @return boolean 
	 */
	public abstract boolean delete(T obj);

	/**
	 * M�thode de mise � jour selon l'id de l'objet
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean update(T obj);

	/**
	 * M�thode de recherche des informations qui retourne un objet T
	 * @param id
	 * @return T
	 */
	public abstract T read(int id);



}