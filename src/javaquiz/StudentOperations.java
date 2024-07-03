package javaquiz;

import java.util.Scanner;

public class StudentOperations {
	public void getStudentOperations() {
		int no = 0;
		Scanner scanner = new Scanner(System.in);
		no = scanner.nextInt();
		switch (no) {

		case 1:
			StudentRegistration sr = new StudentRegistration();
			sr.getStudentInfo();
			break;
		case 2:
			Login login = new Login();
			login.getLogin();
			break;
		case 3:
			System.out.println("Enter user name");
			String username = scanner.next();
			System.out.println("Enter Password");
			String password = scanner.next();
			Score score = new Score();
			score.getScore(username, password);
			break;
		default: {
			System.out.println("Invalid Input");
		}
		}
	}
}

