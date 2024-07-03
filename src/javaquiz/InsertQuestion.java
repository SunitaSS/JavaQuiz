package javaquiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class InsertQuestion {
	
	public void addQuestion()
	{
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			JdbcConnection jdbcconn = new JdbcConnection();
			connection = jdbcconn.getConnectionDetails();
			ps=connection.prepareStatement("insert into que(que,option1,option2,option3,option4,ans )values(?,?,?,?,?,?)");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the question");
			String qu=sc.nextLine();
			
			System.out.println("Enter the option a");
			String op1=sc.nextLine();
			
			System.out.println("Enter the option b");
			String op2=sc.nextLine();
			
			System.out.println("Enter the option c");
			String op3=sc.nextLine();
			
			System.out.println("Enter the option d");
			String op4=sc.nextLine();
            System.out.println("Enter the correct answer for eg:a,b,c,d");
			
			String co=sc.nextLine();
			
			ps.setString(1, qu);;
			ps.setString(2,op1);
			ps.setString(3,op2);
			ps.setString(4,op3);
			ps.setString(5,op4);
			if(co.equals("a")||co.equals("b")||co.equals("c")||co.equals("d")) {
            	
				ps.setString(6,co);
            	
			}
			else {
            	throw new CorrectAnsHandling("Enter the correct answer for eg:a,b,c,d ");

			}
			
            int a = ps.executeUpdate();
			System.out.println("Inserted succesessfully"+a);
			connection.close();
			ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
}
	
}
	

