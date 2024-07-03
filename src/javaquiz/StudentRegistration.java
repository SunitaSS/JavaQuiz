package javaquiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentRegistration {

	public void getStudentInfo() {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		try {
			JdbcConnection jdbcconn = new JdbcConnection();
			connection = jdbcconn.getConnectionDetails();

			System.out.println("Enter the first name");
			String firstname = scanner.next();

			System.out.println("Enter the last name");
			String lastname = scanner.next();

			System.out.println("Enter the Username");
			String userid = scanner.next();

			System.out.println("Enter the Password");
			String Password = scanner.next();

			System.out.println("Enter the city ");
			String city = scanner.next();

			System.out.println("Enter the Mail id ");
			String mailid = scanner.next();

			System.out.println("Enter the Mobile No ");
			int mobileno = scanner.nextInt();

			ps = connection.prepareStatement("select * from student where firstname=? ");
			ps.setString(1, firstname);
			rs = ps.executeQuery();

			connection = jdbcconn.getConnectionDetails();
			ps = connection.prepareStatement(
					"insert into student(firstname,lastname,username,password,city,mailid,mobileno)value(?,?,?,?,?,?,?)");
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, userid);
			ps.setString(4, Password);
			ps.setString(5, city);

			PreparedStatement ps1 = connection.prepareStatement("select mailid from student where mailid=?");
			ps1.setString(1, mailid);
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				String em = rs1.getString(1);
				if (mailid.equals(em)) {
					throw new EmailValid("Email id Already Registered");
				}
			}

			ps.setString(6, mailid);
			ps.setInt(7, mobileno);
			int i = ps.executeUpdate();
			System.out.println("Registration Sucessfully");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private void setString(int i, String mailid) {
		// TODO Auto-generated method stub

	}

}
