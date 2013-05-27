package migrate;

import java.sql.DriverManager;

import com.googlecode.flyway.core.Flyway;
import com.googlecode.flyway.core.api.MigrationVersion;

import databaseManager.databaseManagerImpl.DatabaseManagerSQL;

public class Migrate {

	/**
	 * @param args
	 */
	Flyway flyway = new Flyway();
	
	/**
	 * @param url
	 * @param user
	 * @param password
	 */
	public void setDataSource(String url, String user, String password){
		flyway.setDataSource(url, user, password);
	}
	
	/**
	 * 
	 * @param version
	 */
	public void migrateTo(String version){
		flyway.setTarget(new MigrationVersion(version));
		flyway.migrate();
	}
	
	/**
	 * 
	 */
	public void init(){
		flyway.clean();
	}
	

}
