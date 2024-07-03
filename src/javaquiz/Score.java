package javaquiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Score {
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public void getScore(String UserName, String Password) {

		try {
			JdbcConnection jdbcConnetion = new JdbcConnection();
			connection = jdbcConnetion.getConnectionDetails();
			ps = connection.prepareStatement(
					"select std.stdid,std.firstname,std.lastname,s.score from score s inner join student std on std.stdid=s.stdid \r\n"
							+ "where s.stdid=(select stdid from student  where username=? and password=?)");
			ps.setString(1, UserName);
			ps.setString(2, Password);
			rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("enter correct user id password");
			} else {
				while (rs.next()) {
					System.out.println("Student Id :" + rs.getString(1));
					System.out.println("First Name :" + rs.getString(2));
					System.out.println("Last Name :" + rs.getString(3));
					System.out.println("Score :" + rs.getString(4));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getScore(int StudId) {
		try {
			JdbcConnection jdbcConnetion = new JdbcConnection();
			connection = jdbcConnetion.getConnectionDetails();
			ps = connection.prepareStatement(
					"select std.stdid,std.firstname,std.lastname,s.score from score s inner join student std on std.stdid=s.stdid \r\n"
							+ "where s.stdid=?");
			ps.setInt(1, StudId);
			rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("Student Id Not Match ");
			} else {
				while (rs.next()) {
					System.out.println("Student Id :" + rs.getString(1));
					System.out.println("First Name :" + rs.getString(2));
					System.out.println("Last Name :" + rs.getString(3));
					System.out.println("Score :" + rs.getString(4));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getScore() {
		try {
			JdbcConnection jdbcConnetion = new JdbcConnection();
			connection = jdbcConnetion.getConnectionDetails();
			ps = connection.prepareStatement(
					"select std.stdid,std.firstname,std.lastname,s.score from score s inner join student std on std.stdid=s.stdid");
			rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("No Data Available");
			} else {
				while (rs.next()) {
					System.out.println("Student Id :" + rs.getString(1));
					System.out.println("First Name :" + rs.getString(2));
					System.out.println("Last Name :" + rs.getString(3));
					System.out.println("Score :" + rs.getString(4));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
