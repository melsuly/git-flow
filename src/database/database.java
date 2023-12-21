package database;

import java.sql.*;

public class database {
	public static Connection connection;
	public static Statement statement;
	public static ResultSet resultSet;
	
	public static void connectToDB() throws ClassNotFoundException, SQLException {
		connection = null;
		
		Class.forName("org.sqlite.JDBC");
		
		connection = DriverManager.getConnection("jdbc:sqlite:src/database/main_db.s3db");
	}
	
	public static void createTables() throws ClassNotFoundException, SQLException {
		statement = connection.createStatement();
		statement.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text)");
	}
}
