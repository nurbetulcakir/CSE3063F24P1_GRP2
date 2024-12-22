import java.util.Scanner;

public class AdvisorInterface {

    private static final Scanner scanner = new Scanner(System.in);

    // Main method to run the Advisor Interface
    public void run() {
        while (true) {
            displayMenu();
            int choice = getUserInput();

            switch (choice) {
                case 1:
                    viewStudents();
                    break;
                case 2:
                    approveDisapproveCourses();
                    break;
                case 3:
                    viewNotifications();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return; // Logout
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Display the Advisor menu
    private void displayMenu() {
        System.out.println("\n=== Advisor Menu ===");
        System.out.println("1. View Students");
        System.out.println("2. Approve/Disapprove Courses");
        System.out.println("3. View Notifications");
        System.out.println("4. Logout");
        System.out.print("Please select an option: ");
    }

    // Safely get user input as an integer
    private int getUserInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        return choice;
    }

    // Method to view all students under this advisor
    private void viewStudents() {
        Advisor currentAdvisor = getCurrentAdvisor();

        if (currentAdvisor.getStudentList().isEmpty()) {
            System.out.println("No students are currently assigned to you.");
            return;
        }

        System.out.println("\n=== List of Students ===");
        currentAdvisor.viewStudentList();
    }

    // Method to approve or disapprove student courses
    private void approveDisapproveCourses() {
        Advisor currentAdvisor = getCurrentAdvisor();

        if (currentAdvisor.getAwaitingStudents().isEmpty()) {
            System.out.println("No students are awaiting approval.");
            return;
        }

        System.out.println("\n=== Awaiting Students ===");
        for (int i = 0; i < currentAdvisor.getAwaitingStudents().size(); i++) {
            Student student = currentAdvisor.getAwaitingStudents().get(i);
            System.out.println((i + 1) + ". " + student.getFirstName() + " " + student.getLastName());
        }

        System.out.print("Select a student (1 to " + currentAdvisor.getAwaitingStudents().size() + "): ");
        int studentIndex = getUserInput();
        
        if (studentIndex < 1 || studentIndex > currentAdvisor.getAwaitingStudents().size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Student selectedStudent = currentAdvisor.getAwaitingStudents().get(studentIndex - 1);

        System.out.println("\n1. Approve Courses");
        System.out.println("2. Disapprove Courses");
        System.out.print("Select an option: ");
        int action = getUserInput();

        switch (action) {
            case 1:
                currentAdvisor.approveCourses();
                NotificationSystem.sendAdvisorNotification(currentAdvisor, selectedStudent.getFirstName() + " " + selectedStudent.getLastName() + "'s courses have been approved.");
                System.out.println("Courses approved for " + selectedStudent.getFirstName() + " " + selectedStudent.getLastName());
                break;
            case 2:
                currentAdvisor.disapproveCourses();
                NotificationSystem.sendAdvisorNotification(currentAdvisor, selectedStudent.getFirstName() + " " + selectedStudent.getLastName() + "'s courses have been disapproved.");
                System.out.println("Courses disapproved for " + selectedStudent.getFirstName() + " " + selectedStudent.getLastName());
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    // Method to view notifications for the advisor
    private void viewNotifications() {
        Advisor currentAdvisor = getCurrentAdvisor();

        NotificationSystem.viewAdvisorNotifications(currentAdvisor);

        if (currentAdvisor.getUnreadNotifications().isEmpty()) {
            System.out.println("You have no unread notifications.");
            return;
        }

        System.out.print("\nMark all notifications as read? (y/n): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("y")) {
            NotificationSystem.markAdvisorNotificationsAsRead(currentAdvisor);
            System.out.println("All notifications marked as read.");
        } else {
            System.out.println("Notifications remain unread.");
        }
    }

    // Helper method to get the current logged-in advisor
    private Advisor getCurrentAdvisor() {
        return ObjectCreator.advisors.get(UserInterface.currentAdvisorsIndex);
    }
}
