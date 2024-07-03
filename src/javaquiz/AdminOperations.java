package javaquiz;

import java.util.Scanner;

public class AdminOperations {

	public void getAdminOperations() {
		int no = 0;
		Scanner scanner = new Scanner(System.in);
		no = scanner.nextInt();
		switch (no) {

		case 1:
			InsertQuestion insertQuestion = new InsertQuestion();
			insertQuestion.addQuestion();
			break;
		case 2:
			Score score = new Score();
			score.getScore();
			break;
		case 3:

			System.out.println("Enter Student ID");
			int Studid = scanner.nextInt();
			Score score1 = new Score();
			score1.getScore(Studid);
			break;

		default: {
			System.out.println("Invalid Input");
		}
		}
	}
}
