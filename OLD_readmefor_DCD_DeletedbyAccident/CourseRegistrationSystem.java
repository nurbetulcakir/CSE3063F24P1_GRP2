import java.util.ArrayList;
import java.util.List;

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

	public boolean approveCourses(Student student, Advisor advisor) {
		// Check if the student is assigned to the advisor
		if (!advisor.getStudentList().contains(student)) {
			return false;
		}
	
		// Check if the student is in the awaitingStudents list
		if (!advisor.getAwaitingStudents().contains(student)) {
			return false;
		}
	
		// Approve each chosen course and move it to the approvedCourses list
		for (CourseSection courseSection : student.getChosenCourses()) {
			student.getApprovedCourses().add(courseSection);
		}
	
		student.getChosenCourses().clear();
		advisor.getAwaitingStudents().remove(student);
	
		return true;
	}
	
	public void disapproveCourses(Student student) {
		student.getAdvisor().getAwaitingStudents().remove(student);
		student.getChosenCourses().clear();
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