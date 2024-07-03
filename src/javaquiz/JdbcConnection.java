package javaquiz;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {
	Connection conn = null;

	public Connection getConnectionDetails() { // utility
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaquiz", "root", "@B303Sidhi");
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}