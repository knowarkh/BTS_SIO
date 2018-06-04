package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import dao.Connexion;

class ConnexionTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	 @Test
	    void testGetInstance() {
	        assertTrue("Connexion Impossible !",Connexion.getInstance() != null);
	    }
	    @Test
	    void testExecuteQuery() {
	        assertTrue("Connexion Impossible !",Connexion.executeQuery("SELECT * FROM PILOTE") != null);
	    }
	    
	    //Passer les méthodes en return int pour les tests : 
	    @Test
	    void testFermer() {
	        //assertTrue("Connexion Impossible !",Connexion.fermer() == 1);
	    }
	    @Test
	    void testAfficheSelectEtoile() {
	        //assertTrue("Connexion Impossible !",Connexion.afficheSelectEtoile("PILOTE", "numPil>-1") == 1);
	    }
	    @Test
	    void testGetMaxId() {
	        int id = 0;
	        ResultSet rs = Connexion.executeQuery("SELECT MAX(numPil) as maxNumPil FROM PILOTE");
	        try {
	            rs.next();
	            id = rs.getInt("maxNumPil");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        int result = Connexion.getMaxId("numPil", "PILOTE");
	        
	        assertTrue("Connexion Impossible !",id == result);
	    }
}
