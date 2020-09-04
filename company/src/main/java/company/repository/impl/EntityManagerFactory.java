package company.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;

public class EntityManagerFactory {
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/firstcompanyproject";
			String user = "root";
			String password = "thanhtuan123";
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			return null;
		}
	}
}
