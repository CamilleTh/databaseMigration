package databaseManager.databaseManagerImpl;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import databaseManager.DatabaseManager;

public class DatabaseManagerSQL extends DatabaseManager {
	
	private Connection connection;
	private String url, utilisateur, password;
	
	
	public String getUtilisateur() {
		return utilisateur;
	}
	public String getUrl() {
		return url;
	}
	public String getPassword() {
		return password;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public DatabaseManagerSQL(String url, String utilisateur, String password) {
		this.url=url;
		this.utilisateur=utilisateur;
		this.password=password;
		connect();
	}



	public void connect(){
			
			try { 
		            Class.forName( "com.mysql.jdbc.Driver" );
		        } catch ( ClassNotFoundException e ) {
		            System.out.println( "Erreur lors du chargement : le driver n'a pas été trouvé dans le classpath ! <br/>"
		                    + e.getMessage() );
		        }
			
			try {
				
				this.connection = DriverManager.getConnection( url, utilisateur, password );
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
	}
	
	public void initFlipTable(){
		try {
			Statement statement = this.connection.createStatement();
			
			 statement.execute( "CREATE TABLE IF NOT EXISTS `Fliping`(`idFlip` INT NOT NULL AUTO_INCREMENT,`name` VARCHAR(45) NULL,`value` BOOLEAN DEFAULT 0, PRIMARY KEY (`idFlip`));" ); 
	        // FIN AJOUT LIAISON
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	
	public boolean createFlipBoolean(String name){
		
		boolean success = false; 
		
        try {
			Statement statement = this.connection.createStatement();
			
			 success = statement.execute( "INSERT  INTO `Fliping` (`name`, `value`) VALUES ('"+name+"', '0');" ); 
	        // FIN AJOUT LIAISON
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return success;
		
	}
	
	
	public boolean flipping(String name){
		
		boolean success = false; 
		
        try {
			Statement statement = this.connection.createStatement();
			success = statement.execute("UPDATE `Flip` SET `value` = !`value` WHERE `name` = '"+name+"'");
	        // FIN AJOUT LIAISON
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return success;
	}
	
	public void close(){
		
		if ( connection != null ) {
            try {
            	connection.close();
            } catch ( SQLException ignore ) {
            	ignore.printStackTrace();
            }
        }
	}
	
	public boolean initDirectory(){
		return (new File("src/main/resources/db/migration")).mkdirs();
	}


}


