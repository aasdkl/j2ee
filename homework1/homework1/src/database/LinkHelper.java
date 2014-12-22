package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LinkHelper {

	public static synchronized Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/j2ee";
		String user = "root";
		String password = "aqi";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connection = DriverManager.getConnection(url, user, password);
				return connection;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
				
	}
	
}
