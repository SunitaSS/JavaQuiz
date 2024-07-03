package javaquiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
	public int studId;

	public void getLogin() {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs1 = null;
		String Query = "select  stdid from student where username=? and password=?";
		{
			try {

				Scanner sc = new Scanner(System.in);
				System.out.println("Enter username");
				String Uname = sc.next();

				System.out.println("Enter password");
				String password = sc.next();

				JdbcConnection jdbcconn = new JdbcConnection();
				connection = jdbcconn.getConnectionDetails();
				ps = connection.prepareStatement(Query);
				ps.setString(1, Uname);
				ps.setString(2, password);
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {

						System.out.println("login Sucessfully");

						JavaQuiz javaQuiz = new JavaQuiz();
						javaQuiz.stdid = rs.getInt(1);
						javaQuiz.getque();

					} else {
						System.out.println("invalid input");
					}
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

}
