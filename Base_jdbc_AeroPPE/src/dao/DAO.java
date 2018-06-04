package dao;

import java.util.HashMap;

/**
 * le patron de conception DAO
 * @param <T> pour sérialisation d'objets de type T
 */
public abstract class DAO<T> {
	
	//Création HashMap pour éviter le problème des ref croisées et avoir 1 seul obj en mémoire :
	//associe un entier (clé) et un objet
	private final HashMap <Integer, T> hmap = new HashMap<Integer, T>();
	
	//Redéfinition des méthodes HashMap (pour éviter un extends) :
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
	 * Méthode de création d'un objet de type "T",
	 * peut être amené à injecter l'id créé dans le programme
	 * @param obj
	 * @return boolean 
	 */
	public abstract boolean create(T obj);

	/**
	 * Méthode pour effacer selon l'id de l'objet
	 * @param obj
	 * @return boolean 
	 */
	public abstract boolean delete(T obj);

	/**
	 * Méthode de mise à jour selon l'id de l'objet
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean update(T obj);

	/**
	 * Méthode de recherche des informations qui retourne un objet T
	 * @param id
	 * @return T
	 */
	public abstract T read(int id);



}