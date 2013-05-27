package databaseManager.databaseManagerImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import databaseManager.DatabaseManager;

public class DatabaseManagerSQL extends DatabaseManager {
	
	private Connection connection;
	
	public Connection connection(String url, String utilisateur, String password){
		
			try {
				connection = DriverManager.getConnection( url, utilisateur, password );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
	}
	
	public void initFlipTable(){
		try {
			Statement statement = connection.createStatement();
			
			 statement.execute( "CREATE TABLE IF NOT EXISTS `Flip`(`idFlip` INT NOT NULL AUTO_INCREMENT,`name` VARCHAR(45) NULL,`value` BOOLEAN DEFAULT 0, PRIMARY KEY (`idFlip`));" ); 
	        // FIN AJOUT LIAISON
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean createFlipBoolean(String name){
		
		boolean success = false; 
		
        try {
			Statement statement = connection.createStatement();
			
			 success = statement.execute( "INSERT  INTO `Flipping` (`name`, `value`) VALUES ('"+name+"', '0');" ); 
	        // FIN AJOUT LIAISON
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return success;
		
	}
	
	
	public boolean flipping(String name){
		
		boolean success = false; 
		
        try {
			Statement statement = connection.createStatement();
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

}


