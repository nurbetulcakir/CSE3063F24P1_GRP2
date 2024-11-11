import java.util.Scanner;

public class AdvisorInterface {

    public void run() {
        Scanner scanner = new Scanner(System.in);
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
                    StudentInterface.currentAdvisorsIndex = i;
                    break;
                }
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                	ObjectCreator.advisors.get(StudentInterface.currentAdvisorsIndex).viewStudentList();
                    break;
                case 2:

                    break;
                case 3:
                    ObjectCreator.advisors.get(StudentInterface.currentAdvisorsIndex).ViewAdvisorInfo();
                    break;
                case 4:
                	System.out.println("Logging out...");
                	UserInterface.userIdInput = "";
                	UserInterface.passwordInput = "";
                	StudentInterface.currentStudentsIndex = 999;
                	StudentInterface.currentTranscriptsIndex = 999;
                	StudentInterface.currentAdvisorsIndex = 999;
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}