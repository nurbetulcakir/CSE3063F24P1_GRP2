import java.util.Scanner;

public class CourseRegistrationSimulation {

    // Singleton instance of CourseRegistrationSystem
    private CourseRegistrationSystem crs;

    // Constructor
    public CourseRegistrationSimulation() {
        this.setCrs(CourseRegistrationSystem.getInstance()); // Singleton instance of CRS
    }

    // Main method
    public static void main(String[] args) {
        CourseRegistrationSimulation simulation = new CourseRegistrationSimulation();
        simulation.run();
    }

    // Menu
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Course Registration System Menu:");
            System.out.println("1. Enroll course");
            System.out.println("2. Drop course");
            System.out.println("3. Assign advisor to student");
            System.out.println("4. Approve student");
            System.out.println("5. Disapprove student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    enrollCourse();
                    break;
                case 2:
                    dropCourse();
                    break;
                case 3:
                    assignStudentToAdvisor();
                    break;
                case 4:
                    approveStudent();
                    break;
                case 5:
                    disapproveStudent();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void enrollCourse() {
        // Method to enroll a student in a course
    }

    private void dropCourse() {
        // Method to drop a course for a student
    }

    private void assignStudentToAdvisor() {
        // Method to assign a student to an advisor
    }

    private void approveStudent() {
        // Method to approve a student
    }

    private void disapproveStudent() {
        // Method to disapprove a student
    }

	public CourseRegistrationSystem getCrs() {
		return crs;
	}

	public void setCrs(CourseRegistrationSystem crs) {
		this.crs = crs;
	}
}