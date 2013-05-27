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
	
	public boolean createFlipBoolean(String name){
		
		boolean success = false; 
		
        try {
			Statement statement = connection.createStatement();
			
			 success = statement.execute( "INSERT  INTO `Flipping` (`name`) VALUES ('"+name+"');" ); 
	        // FIN AJOUT LIAISON
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return success;
		
	}

}
