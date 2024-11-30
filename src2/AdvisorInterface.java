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
                    UserInterface.currentAdvisorsIndex = i;
                    break;
                }
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                	ObjectCreator.advisors.get(UserInterface.currentAdvisorsIndex).viewStudentList();
                    break;
                case 2:

                    break;
                case 3:
                    ObjectCreator.advisors.get(UserInterface.currentAdvisorsIndex).ViewAdvisorInfo();
                    break;
                case 4:
                	System.out.println("Logging out...");
                	UserInterface.userIdInput = "";
                	UserInterface.passwordInput = "";
                	UserInterface.currentStudentsIndex = 999;
                	UserInterface.currentTranscriptsIndex = 999;
                	UserInterface.currentAdvisorsIndex = 999;
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    public boolean assignStudentToAdvisor(Student student, Advisor advisor) {
		// Check if the student already has an assigned advisor
		if (student.getAdvisor() != null) {
			return false;
		}
	
		// Check if the student is already in the advisor's student list
		if (advisor.getStudentList().contains(student)) {
			return false;
		}
	
		// Add the student to the advisor's student list
		advisor.getStudentList().add(student);
		student.setAdvisor(advisor);
	
		return true;
	}
	public boolean removeStudentFromAdvisor(Student student, Advisor advisor) {
		// Check if the student is assigned to this advisor
		if (!advisor.getStudentList().contains(student)) {
			return false;
		}
	
		advisor.getStudentList().remove(student);
		student.setAdvisor(null);
	
		return true;
	}
}