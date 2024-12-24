import java.util.Scanner;

public class AdvisorInterface {

    private static Scanner scanner = new Scanner(System.in);

    // Main method to run the Advisor Interface
    public void run() {
        while (true) {
            System.out.println("\n=== Advisor Menu ===");
            System.out.println("1. View Students");
            System.out.println("2. Approve/Disapprove Courses");
            System.out.println("3. View Notifications");
            System.out.println("4. Logout");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

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
                    return;  // Logout
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to view all students under this advisor
    private void viewStudents() {
        Advisor currentAdvisor = getCurrentAdvisor();
        currentAdvisor.viewStudentList();
    }

    // Method to approve or disapprove student courses
    private void approveDisapproveCourses() {
        Advisor currentAdvisor = getCurrentAdvisor();
        System.out.println("\nSelect a student to approve/disapprove courses:");

        // Display all awaiting students
        for (int i = 0; i < currentAdvisor.getAwaitingStudents().size(); i++) {
            Student student = currentAdvisor.getAwaitingStudents().get(i);
            System.out.println((i + 1) + ". " + student.getFirstName() + " " + student.getLastName());
        }
        
        System.out.print("Select student (1 to " + currentAdvisor.getAwaitingStudents().size() + "): ");
        int studentIndex = scanner.nextInt();
        scanner.nextLine();  

        if (studentIndex < 1 || studentIndex > currentAdvisor.getAwaitingStudents().size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Student selectedStudent = currentAdvisor.getAwaitingStudents().get(studentIndex - 1);

        // Approve or Disapprove courses for the student
        System.out.println("Select an option:");
        System.out.println("1. Approve Courses");
        System.out.println("2. Disapprove Courses");
        int action = scanner.nextInt();
        scanner.nextLine();  

        if (action == 1) {
            currentAdvisor.approveCourses();  // Approve selected student's courses
            NotificationSystem.sendAdvisorNotification(currentAdvisor, selectedStudent.getFirstName() + " " + selectedStudent.getLastName() + "'s courses have been approved.");
        } else if (action == 2) {
            currentAdvisor.disapproveCourses();  // Disapprove selected student's courses
            NotificationSystem.sendAdvisorNotification(currentAdvisor, selectedStudent.getFirstName() + " " + selectedStudent.getLastName() + "'s courses have been disapproved.");
        } else {
            System.out.println("Invalid option.");
        }
    }

    // Method to view the notifications for the advisor
    private void viewNotifications() {
        Advisor currentAdvisor = getCurrentAdvisor();
        NotificationSystem.viewAdvisorNotifications(currentAdvisor);
        
        System.out.print("\nMark all notifications as read? (y/n): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            NotificationSystem.markAdvisorNotificationsAsRead(currentAdvisor);
        }
    }

    // Helper method to get the current logged-in advisor
    private Advisor getCurrentAdvisor() {
        return ObjectCreator.advisors.get(UserInterface.currentAdvisorsIndex);
    }
}
