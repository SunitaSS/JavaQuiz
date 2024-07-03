package javaquiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JavaQuiz {
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public int stdid;
	int count = 0;

	public void getque() throws SQLException {
		int correct = 0;
		int wrong = 0;
		try {
			JdbcConnection jdbcconn = new JdbcConnection();
			connection = jdbcconn.getConnectionDetails();
			ps = connection.prepareStatement("select * from que");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1) + ")" + rs.getString(2));
				System.out.println("A )" + rs.getString(3) + "   " + " B )" + rs.getString(4));
				System.out.println("C )" + rs.getString(5) + "   " + " D )" + rs.getString(6));
				Scanner scanner = new Scanner(System.in);
				System.out.println("Ans :");
				String sans = scanner.next();
				String ans = rs.getString(7);

				if (sans.equals(ans)) {
					correct++;
				} else {
					wrong++;
				}

			}
			ps = connection.prepareStatement("select count(QueId) from que");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Your Score : " + correct + "/" + rs.getString(1));
			}

			ps = connection.prepareStatement("insert into score (stdid,score)value(?,?)");
			ps.setInt(1, stdid);
			ps.setInt(2, correct);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
			ps.close();
			rs.close();

		}
	}
}
