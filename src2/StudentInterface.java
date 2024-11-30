import java.util.Scanner;

public class StudentInterface {

	public void run() {
		try (Scanner scanner = new Scanner(System.in)) {
			WhileLoop:
			while (true) {
			    System.out.println("Welcome to Information Management System! What would you like to do?");
			    System.out.println("1. View schedule");
			    System.out.println("2. View transcript");
			    System.out.println("3. View advisor information");
			    System.out.println("4. Register for the current term");
			    System.out.println("5. Send courses for approval");
			    System.out.println("6. View notifications");
			    System.out.println("7. Logout");
			    System.out.print("Please type the number of your selection: ");
			    
			    
			    int choice = scanner.nextInt(); 
			    scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                	ObjectCreator.students.get(UserInterface.currentStudentsIndex).viewSchedule();
                    break;
                case 2:
                	ObjectCreator.transcripts.get(UserInterface.currentTranscriptsIndex).viewTranscript();
                    break;
                case 3:
                	for(int i = 0; i < ObjectCreator.advisors.size(); i++) {
                		if (ObjectCreator.advisors.get(i).getLecturerID().getId() == ObjectCreator.students.get(UserInterface.currentStudentsIndex).getAdvisor().getLecturerID().getId()) {
            	    		UserInterface.currentAdvisorsIndex = i;
                		}
                	}
                	ObjectCreator.advisors.get(UserInterface.currentAdvisorsIndex).ViewAdvisorInfo();
                    break;
                case 4:
                	chooseCourse(ObjectCreator.students.get(UserInterface.currentStudentsIndex), new CourseSection(choice, null, null, choice));
                    break;
                case 5:
                	ObjectCreator.students.get(UserInterface.currentStudentsIndex).sendForApproval();
                    break;
                case 6:
                	/* VIEW NOTIFICATIONS */
                	break;
                case 7:
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
	}
	
	public boolean chooseCourse(Student student, CourseSection courseSection) {
		// Check prerequisites
		if (!student.isPrerequisiteCoursesPassed(courseSection.getCourse())) {
			return false;
		}
	
		// Check course capacity
		if (courseSection.getCapacity() <= 0) {
			return false;
		}
	
		// Check if the student is already enrolled in this course section
		if (student.getChosenCourses().contains(courseSection)) {
			return false;
		}
		// Check if the student's term matches the course term
		if (student.getTerm() < courseSection.getCourse().getCourseTerm()) {
			return false;
		}
		// Check if the student has reached the maximum number of courses
		if (student.getChosenCourses().size() >= 5) {
			return false;
		}
	
		student.getChosenCourses().add(courseSection);
		courseSection.getEnrolledStudents().add(student);
		courseSection.setCapacity(courseSection.getCapacity() - 1);
		return true;
	}
	
	public boolean dropCourse(Student student, CourseSection courseSection) {
		// Check if the student is enrolled in the course section
		if (!student.getChosenCourses().contains(courseSection)) {
			return false;
		}
	
		courseSection.getEnrolledStudents().remove(student);
		student.getChosenCourses().remove(courseSection);
		// Increase the capacity by 1 as the student is now unenrolled
		courseSection.setCapacity(courseSection.getCapacity() + 1);
	
		return true;
	}
}
