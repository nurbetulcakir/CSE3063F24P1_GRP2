import java.util.Scanner;

public class StudentInterface {
	static int currentStudentsIndex;
	static int currentTranscriptsIndex;
	static int currentAdvisorsIndex;
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
			    System.out.println("6. Logout");
			    System.out.print("Please type the number of your selection: ");
			    
			    for (int i = 0; i < ObjectCreator.students.size(); i++) {
			    	if (ObjectCreator.students.get(i).getStudentID().getId() == UserInterface.userIdInput) {
			    		currentStudentsIndex = i;
			    		break;
			    	}
			    }
			    
			    for (int i = 0; i < ObjectCreator.transcripts.size(); i++) {
			    	if (ObjectCreator.transcripts.get(i).getStudentID().getId() == UserInterface.userIdInput) {
			    		currentTranscriptsIndex = i;
			    		break;
			    	}
			    }
			    
			    int choice = scanner.nextInt(); 
			    scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                	ObjectCreator.students.get(currentStudentsIndex).viewSchedule();
                    break;
                case 2:
                	ObjectCreator.transcripts.get(currentTranscriptsIndex).viewTranscript();
                    break;
                case 3:
                	for(int i = 0; i < ObjectCreator.advisors.size(); i++) {
                		if (ObjectCreator.advisors.get(i).getLecturerID().getId() == ObjectCreator.students.get(StudentInterface.currentStudentsIndex).getAdvisor().getLecturerID().getId()) {
            	    		StudentInterface.currentAdvisorsIndex = i;
                		}
                	}
                	ObjectCreator.advisors.get(currentAdvisorsIndex).ViewAdvisorInfo();
                    break;
                case 4:
                	chooseCourse(ObjectCreator.students.get(currentStudentsIndex), new CourseSection());
                    break;
                case 5:
                	ObjectCreator.students.get(currentStudentsIndex).sendForApproval();
                    break;
                case 6:
                	System.out.println("Logging out...");
                	UserInterface.userIdInput = "";
                	UserInterface.passwordInput = "";
                	currentStudentsIndex = 999;
                	currentTranscriptsIndex = 999;
                	currentAdvisorsIndex = 999;
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
