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
        this.setStudents(new ArrayList<>());
        this.setAdvisors(new ArrayList<>());
        this.setCourses(new ArrayList<>());
        this.setCourseSections(new ArrayList<>());
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