package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Database {
	// Object for database connection.
	protected Connection con;

	// Object for dynamic SQL commands manipulation.
	protected PreparedStatement pst;

	// Object for static SQL commands manipulation.
	protected Statement st;

	// Object that references the table resulted from a search (SELECT).
	protected ResultSet rs;

	private String database = "dokkan_calculator";
	private String url = "jdbc:mysql://localhost:3306/" + database
			+ "?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
	private String user = "root";
	private String password = "admin";

	public Database() {
		connectToDatabase();
	}
	
	public void connectToDatabase() {
		try {
			System.out.println("here");
			con = DriverManager.getConnection(url, user, password);
			System.out.print("yey ");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

}
