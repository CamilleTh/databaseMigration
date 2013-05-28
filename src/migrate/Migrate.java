package migrate;

import com.googlecode.flyway.core.Flyway;
import com.googlecode.flyway.core.api.MigrationVersion;

import databaseManager.DatabaseManager;
import databaseManager.databaseManagerImpl.DatabaseManagerSQL;

public class Migrate {

	/**
	 * @param args
	 */
	Flyway flyway;
	DatabaseManager databaseManager;
	
	/**
	 * @param url
	 * @param user
	 * @param password
	 */
	
	/**
	 * 
	 * @param version
	 */
	
	public Migrate() {
		this.flyway=new Flyway();
	}
	
	// Migration vers une version X
	public void migrateTo(String version){
		
		flyway.setTarget(new MigrationVersion(version));
		flyway.migrate();
	}
	
	/**
	 * 
	 */
	public void initAndReset(){
		
		
		flyway.clean(); // reset de la base
		databaseManager.initDirectory(); // creation du dossier de fichier de migration SQL
		databaseManager.initFlipTable(); // creation de la table pour gérer le flipping
	}
	
	public void init(){
		
		databaseManager.initDirectory(); // creation du dossier de fichier de migration SQL
		databaseManager.initFlipTable(); // creation de la table pour gérer le flipping
	}


	// Creation d'un boolean de flipping
	public boolean createFlipBoolean(String name){
		return databaseManager.createFlipBoolean(name);
	}
	
	// Flippng d'un boolean
	public boolean flipping(String name){
		return databaseManager.flipping(name);
	}
	
	// Connection à la base de données
	public void setDataSourceSQL(String url, String user, String password) {
		databaseManager = new DatabaseManagerSQL(url, user, password);
		flyway.setDataSource(((DatabaseManagerSQL) databaseManager).getUrl(), ((DatabaseManagerSQL)databaseManager).getUtilisateur(),((DatabaseManagerSQL) databaseManager).getPassword());
		
	}


	


}
