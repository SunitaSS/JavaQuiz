package javaquiz;

import java.util.Scanner;

public class Quiz {
	int s;

	public static void main(String args[]) {

		{
			System.out.println("Welcome to Quiz based application");
			System.out.println("1.Student ");
			System.out.println("2.Admin ");
			System.out.println("Enter your choice ");
			Scanner scanner = new Scanner(System.in);
			int s = scanner.nextInt();
			if (s == 1) {

				System.out.println("1.Student Registration");
				System.out.println("2.Student Login and Start Quiz");
				System.out.println("3.Display Quiz result");
				StudentOperations so = new StudentOperations();
				so.getStudentOperations();
			} else {

				System.out.println("1.Add question ");
				System.out.println("2.Display All Student Quiz result");
				System.out.println("3.Fetch student score by using id");
				AdminOperations ao = new AdminOperations();
				ao.getAdminOperations();
			}
		}
	}
}