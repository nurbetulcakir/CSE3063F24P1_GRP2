import java.util.ArrayList;

public class Course {
    // Attributes
    private ID courseID;
    private String courseName;
    private ArrayList<Course> prerequisiteCourse = new ArrayList<Course>();

    // Constructor
    public Course(ID courseID, String courseName, ArrayList<Course> prerequisiteCourse) {
        this.setCourseID(courseID);
        this.setCourseName(courseName);
        this.prerequisiteCourse = new ArrayList<>(); // Start as an empty list
    }

    // Method to add a prerequisite course
    public void addPrerequisiteCourse(Course course) {
        // Adds a course to the list of prerequisites.
        prerequisiteCourse.add(course);
    }

	public ID getCourseID() {
		return courseID;
	}

	public void setCourseID(ID courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
    
    
    

}