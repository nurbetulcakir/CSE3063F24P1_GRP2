import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    // Attributes
    private Advisor advisor;
    private int year;
    private List<CourseSection> enrolledCourses;
    private List<Course> successedCourses;

    // Constructor
    public Student(ID personID, Password password, String firstName, String secondName, 
                   CourseRegistrationSystem courseRegistrationSystem, Advisor advisor, 
                   int year, List<Course> successedCourses) {
        super(personID, password, firstName, secondName, courseRegistrationSystem);
        this.advisor = advisor;
        this.year = year;
        this.enrolledCourses = new ArrayList<>(); // Start as an empty list
        this.successedCourses = successedCourses;  // Initialize with data from JSON
    }

    // Methods
    @Override
    public boolean login(String personID, Password password) {
        // Handles login functionality. Returns true if login is successful.
        return true; // Temporary implementation
    }

    @Override
    public void logout() {
        // Handles logout functionality.
    }

    public List<Course> viewCourses() {
        // Returns the list of completed courses.
        return successedCourses;
    }

    public String viewSchedule() {
        // Returns the schedule of the student as a string.
        return "Student schedule"; // Temporary implementation
    }

    // Getters and Setters
    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<CourseSection> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<CourseSection> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public List<Course> getSuccessedCourses() {
        return successedCourses;
    }

    public void setSuccessedCourses(List<Course> successedCourses) {
        this.successedCourses = successedCourses;
    }
}
