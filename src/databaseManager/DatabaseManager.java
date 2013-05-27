package databaseManager;

import java.io.File;
import java.sql.Connection;

public abstract class DatabaseManager {

	public abstract boolean createFlipBoolean(String name);
	
	public abstract void connect();
	

}
