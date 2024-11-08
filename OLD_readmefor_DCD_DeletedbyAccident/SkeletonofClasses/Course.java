import java.util.ArrayList;
import java.util.List;

public class Course {
    // Attributes
    private ID courseID;
    private String courseName;
    private List<Course> prerequisites;
    private CourseRegistrationSystem courseRegistrationSystem;

    // Constructor
    public Course(ID courseID, String courseName, CourseRegistrationSystem courseRegistrationSystem) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseRegistrationSystem = courseRegistrationSystem;
        this.prerequisites = new ArrayList<>(); // Start as an empty list
    }

    // Method to add a prerequisite course
    public void addPrerequisite(Course course) {
        // Adds a course to the list of prerequisites.
        prerequisites.add(course);
    }

    // Getters and Setters
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

    public List<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public CourseRegistrationSystem getCourseRegistrationSystem() {
        return courseRegistrationSystem;
    }

    public void setCourseRegistrationSystem(CourseRegistrationSystem courseRegistrationSystem) {
        this.courseRegistrationSystem = courseRegistrationSystem;
    }
}
