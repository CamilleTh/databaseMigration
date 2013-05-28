package test;

import migrate.MigrationManager;

public class Exemple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	
    	// Creation de l'objet
    	MigrationManager m = new  MigrationManager();
    	
    	// Lien avec la base et connection 
    	m.setDataSourceSQL("jdbc:mysql://mysql1.alwaysdata.com/40853_intech", "40853_2", "intech");
    	
    	// creation du répertoire pour déposer ces fichiers de migration, creation de la table pour la gestion du flipping
    	m.init();
    	
    	// Initialisation de la base de données, creation du répertoire pour déposer ces fichiers de migration, creation de la table pour la gestion du flipping
    	m.initAndReset();

    	// migration vers la V1
    	m.migrateTo("1");
    	
    	// Creation d'un boolean de flipping : test
    	m.createFlipBoolean("test");
    	
    	// flipping du boolean de la base
    	m.flipping("test");
	}

}
