package databaseManager;

import java.io.File;
import java.sql.Connection;

public abstract class DatabaseManager {

	public abstract boolean createFlipBoolean(String name);

	public abstract void connect();

	public abstract boolean initDirectory();

	public abstract void close();

	public abstract boolean flipping(String name);
	
	public abstract void initFlipTable();



}
