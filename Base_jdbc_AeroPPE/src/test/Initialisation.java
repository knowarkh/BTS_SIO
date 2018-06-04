package test;

import dao.Connexion;

public class Initialisation {

	public static void main(String[] args) {
		initialisation();
		Connexion.fermer();
	}
	public static void initialisation() {
		Connexion.executeUpdate("DROP TABLE VOL;");
		Connexion.executeUpdate("DROP TABLE PILOTE;");
		Connexion.executeUpdate("DROP TABLE AVION;");
		String requeteCreateTablePilote = "CREATE TABLE PILOTE\r\n" + 
				"	(numPil int IDENTITY(1,1) PRIMARY KEY not NULL,\r\n" + 
				"	nomPil varchar(100) not NULL,\r\n" + 
				"	adr varchar(100) not NULL,\r\n" + 
				"	sal int not NULL);";
		Connexion.executeUpdate(requeteCreateTablePilote);
		String requeteInsertTuplePilote = "INSERT INTO PILOTE (nomPil,adr,sal)\r\n" + 
				"VALUES ('Jean','Nantes','15000'),\r\n" + 
				"('Mat','Rennes','13000'),\r\n" + 
				"('Obi-Wan','Nice','30000'),\r\n" + 
				"('Deckard','Vannes','20000'),\r\n" + 
				"('Dupont','Nice','10000'),\r\n" + 
				"('Durand','Paris','25000'),\r\n" + 
				"('Alain','Paris','17000'),\r\n" + 
				"('Dupont','Marseille','19000'),\r\n" + 
				"('Dupont','Nice','21000');";
		Connexion.executeUpdate(requeteInsertTuplePilote);
		String requeteCreateTableAvion = "CREATE TABLE AVION\r\n" + 
				"	(numAv int IDENTITY(1,1) PRIMARY KEY not NULL,\r\n" + 
				"	nomAv varchar(100) not NULL,\r\n" + 
				"	capacite int not NULL,\r\n" + 
				"	loc varchar(100)not NULL);";
		Connexion.executeUpdate(requeteCreateTableAvion);
		String requeteInsertTupleAvion = "INSERT INTO AVION (nomAv,capacite,loc)\r\n" + 
				"VALUES ('airbus','250','Paris'),\r\n" + 
				"('boeing','350','Nice'),\r\n" + 
				"('airbus','200','La Roche sur Yon'),\r\n" + 
				"('boeing','400','Nantes'),\r\n" + 
				"('airbus','370','Vannes'),\r\n" + 
				"('airbus','340','Rennes'),\r\n" + 
				"('boeing','300','Paris');";
		Connexion.executeUpdate(requeteInsertTupleAvion);
		String requeteCreateTableVol = "CREATE TABLE VOL\r\n" + 
				"	(numVol int IDENTITY(1,1) PRIMARY KEY not NULL,\r\n" + 
				"	numPil int FOREIGN KEY REFERENCES PILOTE(numPil) not NULL,\r\n" + 
				"	numAv int FOREIGN KEY REFERENCES AVION(numAv) not NULL,\r\n" + 
				"	villeDep varchar(100) not NULL,\r\n" + 
				"	villeArr varchar(100) not NULL,\r\n" + 
				"	hDep datetime not NULL,\r\n" + 
				"	hArr datetime not NULL);";
		Connexion.executeUpdate(requeteCreateTableVol);
		String requeteInsertTupleVol = "INSERT INTO VOL (numPil,numAv,villeDep,villeArr,hDep,hArr)\r\n" + 
				"VALUES ('1','3','Nice','Paris','2017-10-3 14:30:00','2017-10-3 16:30:00'),\r\n" + 
				"('2','5','Rennes','Paris','2017-10-3 12:00:00','2017-10-3 12:45:00'),\r\n" + 
				"('6','1','Paris','Nice','2017-10-3 18:00:00','2017-10-3 20:00:00'),\r\n" + 
				"('4','2','Vannes','Paris','2017-10-3 22:00:00','2017-10-3 23:00:00'),\r\n" + 
				"('5','4','Rennes','Nice','2017-10-3 21:00:00','2017-10-3 22:45:00'),\r\n" + 
				"('3','2','Nantes','Vannes','2017-10-10 08:35:00','2017-10-10 09:05:00'),\r\n" + 
				"('2','3','Vannes','La Roche sur Yon','2017-10-3 09:30:00','2017-10-3 10:00:00'),\r\n" + 
				"('1','2','Paris','Rennes','2017-10-3 09:30:00','2017-10-3 10:45:00'),\r\n" + 
				"('3','6','Nice','Paris','2017-10-3 20:30:00','2017-10-3 21:50:00'),\r\n" + 
				"('5','3','Paris','Nantes','2017-10-3 10:30:00','2017-10-3 11:30:00'),\r\n" + 
				"('1','2','Nantes','Nice','2017-10-3 11:35:00','2017-10-3 12:35:00'),\r\n" + 
				"('7','5','Nice','Renne','2017-10-3 12:05:00','2017-10-3 12:50:00'),\r\n" + 
				"('5','1','Vannes','Nice','2017-10-3 12:10:00','2017-10-3 13:10:00'),\r\n" + 
				"('6','3','Rennes','Nantes','2017-10-10 08:30:00','2017-10-10 09:00:00');";
		Connexion.executeUpdate(requeteInsertTupleVol);
		Connexion.fermer();
	}
}
