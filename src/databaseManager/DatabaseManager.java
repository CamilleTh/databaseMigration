package databaseManager;

import java.sql.Connection;

public abstract class DatabaseManager {

	public abstract boolean createFlipBoolean(String name);
	
	public abstract Connection connection(String url, String utilisateur, String password);
	
	
}
