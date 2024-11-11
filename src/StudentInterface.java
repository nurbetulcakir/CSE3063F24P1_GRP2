import java.util.Scanner;

public class StudentInterface {
	int currentStudentsElement;
	int currentTranscriptsElement;
	public void run() {
		Scanner scanner = new Scanner(System.in);
        WhileLoop:
		while (true) {
            System.out.println("Welcome to Information Management System! What would you like to do?");
            System.out.println("1. View schedule");
            System.out.println("2. View transcript");
            System.out.println("3. View advisor information");
            System.out.println("4. Register for the current term");
            System.out.println("5. Send courses for approval");
            System.out.println("6. Logout");
            System.out.print("Please type the number of your selection: ");
            
            for (int i = 0; i < 10; i++) {
            	if (ObjectCreator.students.get(i).getStudentID().getId() == UserInterface.userIdInput) {
            		currentStudentsElement = i;
            		break;
            	}
            }
            
            for (int i = 0; i < 10; i++) {
            	if (ObjectCreator.transcripts.get(i).getStudentID().getId() == UserInterface.userIdInput) {
            		currentTranscriptsElement = i;
            		break;
            	}
            }
            
            int choice = scanner.nextInt(); 
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    break;
                case 2:
                	ObjectCreator.transcripts.get(currentTranscriptsElement).viewTranscript();
                    break;
                case 3:
                	ObjectCreator.students.get(currentStudentsElement).viewAdvisor();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                	System.out.println("Logging out...");
                	UserInterface.userIdInput = "";
                	UserInterface.passwordInput = "";
                	currentStudentsElement = 0;
                	currentTranscriptsElement = 0;
                    break WhileLoop;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
	}
	
}
