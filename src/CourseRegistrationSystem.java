import java.util.ArrayList;

public class CourseRegistrationSystem {
    // Singleton instance of CourseRegistrationSystem
    private static CourseRegistrationSystem instance = new CourseRegistrationSystem();

    // Attributes
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Advisor> advisors = new ArrayList<Advisor>();
    private ArrayList<Course> courses = new ArrayList<Course>();
    private ArrayList<CourseSection> courseSections = new ArrayList<CourseSection>();
    private String currentRole;

    // Private constructor for singleton pattern
    private CourseRegistrationSystem() {
        // No need to set empty lists here since they are initialized at declaration
    }

//	public boolean login(String personID, String password) {
//		// Checking if someone is already logged in
//		if (currentRole != null) {
//			System.out.println("A user is already logged in. Please logout first.");
//			return false;
//		}
//
//        // Searching among students
//        for (Student student : students) {
//            if (student.getStudentID().equals(personID) && student.getPassword().equals(password)) {
//                currentRole = "Student";
//                System.out.println("Login successful as Student.");
//                return true;
//            }
//        }
//
//        // Searching among advisors
//        for (Advisor advisor : advisors) {
//            if (advisor.getLecturerID().equals(personID) && advisor.getPassword().equals(password)) {
//                currentRole = "Advisor";
//                System.out.println("Login successful as Advisor.");
//                return true;
//            }
//        }
//
//        // When authentication fails
//        System.out.println("Login failed. Incorrect ID or password.");
//        return false;
//    }
//
//	public void logout() {
//		// Resetting the current role to indicate no user is logged in
//		currentRole = null;
//		System.out.println("Logout successful.");
//	}
//
//	public boolean validatePrerequisites(Student student, CourseSection courseSection) {
//		Course course = courseSection.getCourse();
//		List<Course> prerequisites = course.viewPrerequisiteCourses();
//
//		// Check if the student has passed all prerequisite courses
//		for (Course prerequisite : prerequisites) {
//			if (!student.getPassedCourses().contains(prerequisite)) {
//				System.out.println("Prerequisite not met for course: " + course.getCourseName());
//				return false;
//			}
//		}
//
//		System.out.println("All prerequisites met for course: " + course.getCourseName());
//		return true;
//    }

	public void dropCourse(Student student, CourseSection courseSection) {
    	// Check if the student is enrolled in the course section
    	if (!student.getChosenCourses().contains(courseSection)) {
     	   System.out.println("Drop failed. The student is not enrolled in the course: " + courseSection.getCourse().getCourseName());
    	    return;
    	}

    	// Remove the student from the course section's enrolled students list
    	courseSection.getEnrolledStudents().remove(student);

    	// Remove the course section from the student's chosen courses list
    	student.getChosenCourses().remove(courseSection);

    	System.out.println("Course dropped successfully: " + courseSection.getCourse().getCourseName());
    }

	public void assignStudentToAdvisor(Student student, Advisor advisor) {
		// Check if the student already has an assigned advisor
		if (student.getAdvisor() != null) {
			System.out.println("Assignment failed. The student is already assigned to an advisor.");
			return;
		}
	
		// Check if the student is already in the advisor's student list
		if (advisor.getStudentList().contains(student)) {
			System.out.println("Assignment failed. The student is already in this advisor's list.");
			return;
		}
	
		// Add the student to the advisor's student list
		advisor.getStudentList().add(student);
	
		// Set the student's advisor
		student.setAdvisor(advisor);
	
		System.out.println("Student assigned successfully to advisor: " + advisor.getLecturerID());
	}

	public void removeStudentFromAdvisor(Student student, Advisor advisor) {
		// Check if the student is assigned to this advisor
		if (!advisor.getStudentList().contains(student)) {
			System.out.println("Removal failed. The student is not assigned to this advisor.");
			return;
		}
	
		// Remove the student from the advisor's student list
		advisor.getStudentList().remove(student);
	
		// Clear the advisor reference from the student
		student.setAdvisor(null);
	
		System.out.println("Student removed successfully from advisor: " + advisor.getLecturerID());
	}

	public void approveCourses(Student student, Advisor advisor) {
		// Check if the student is assigned to the advisor
		if (!advisor.getStudentList().contains(student)) {
			System.out.println("Approval failed. The student is not assigned to this advisor.");
			return;
		}
	
		// Approve each chosen course and move it to the approvedCourses list
		for (CourseSection courseSection : student.getChosenCourses()) {
			student.getApprovedCourses().add(courseSection);
		}
	
		// Clear the chosenCourses list after approval
		student.getChosenCourses().clear();
	
		System.out.println("Courses approved successfully for student: " + student.getStudentID());
	}
	
	public void disapproveCourses(Student student) {
		System.out.println("Courses not approved for student: " + student.getStudentID());
	}
	
	public static CourseRegistrationSystem getInstance() {
		return instance;
	}

	public static void setInstance(CourseRegistrationSystem instance) {
		CourseRegistrationSystem.instance = instance;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public ArrayList<Advisor> getAdvisors() {
		return advisors;
	}

	public void setAdvisors(ArrayList<Advisor> advisors) {
		this.advisors = advisors;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public ArrayList<CourseSection> getCourseSections() {
		return courseSections;
	}

	public void setCourseSections(ArrayList<CourseSection> courseSections) {
		this.courseSections = courseSections;
	}

	public String getCurrentRole() {
		return currentRole;
	}

	public void setCurrentRole(String currentRole) {
		this.currentRole = currentRole;
	}

}