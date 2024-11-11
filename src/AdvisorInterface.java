

import java.util.Scanner;

public class AdvisorInterface {
    private int currentAdvisorIndex;

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
			WhileLoop:
			while (true) {
			    System.out.println("Welcome to Information Management System! What would you like to do?");
			    System.out.println("1. View Students");
			    System.out.println("2. Approve/Disapprove Courses");
			    System.out.println("3. View advisor information");
			    System.out.println("4. Logout");
			    System.out.print("Please type the number of your selection: ");

			    for (int i = 0; i < ObjectCreator.advisors.size(); i++) {
			        if (ObjectCreator.advisors.get(i).getLecturerID().getId().equals(UserInterface.userIdInput)) {
			            currentAdvisorIndex = i;
			            break;
			        }
			    }

			    int choice = scanner.nextInt();
			    scanner.nextLine(); // Consume newline

			    switch (choice) {
			        case 1:
			        	Advisor.getStudentList();
			            break;
			        case 2:
			        	Advisor.ApproveDisapproveCourses();
			            break;
			        case 3:
			            ObjectCreator.advisors.get(currentAdvisorIndex).ViewAdvisorInfo();
			            break;
			        case 4:
			            System.out.println("Logging out...");
			            UserInterface.userIdInput = "";
			            UserInterface.passwordInput = "";
			            currentAdvisorIndex = 0;
			            break WhileLoop;
			        default:
			            System.out.println("Invalid option. Please try again.");
			    }
			}
		}
    }
}

