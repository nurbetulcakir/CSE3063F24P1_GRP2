import java.util.Scanner;

public class StudentInterface {
	String currentStudentID;
	int currentStudentsElement;
	int currentTranscriptsElement;
	public void run() {
		Scanner scanner = new Scanner(System.in);
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
            	if (ObjectCreator.students.get(i).getStudentID().getId() == currentStudentID) {
            		currentStudentsElement = i;
            		break;
            	}
            }
            
            for (int i = 0; i < 10; i++) {
            	if (ObjectCreator.transcripts.get(i).getStudentID().getId() == currentStudentID) {
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
                	ObjectCreator.students.get(currentStudentsElement).getAdvisor();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
	}
	
}
