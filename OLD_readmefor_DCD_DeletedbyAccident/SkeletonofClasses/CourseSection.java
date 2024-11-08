import java.util.ArrayList;
import java.util.List;

public class CourseSection {
    // Attributes
    private ID sectionID;
    private List<SessionTime> allSessions;
    private Course course; // Composition relationship with Course
    private List<Student> enrolledStudents;
    private int capacity;
    private CourseRegistrationSystem courseRegistrationSystem;

    // Constructor
    public CourseSection(ID sectionID, Course course, int capacity, 
                         CourseRegistrationSystem courseRegistrationSystem) {
        this.sectionID = sectionID;
        this.course = course; // Course is a required component for CourseSection (Composition)
        this.capacity = capacity;
        this.courseRegistrationSystem = courseRegistrationSystem;
        this.allSessions = new ArrayList<>(); // Start as an empty list
        this.enrolledStudents = new ArrayList<>(); // Start as an empty list
    }

    // Method to get the number of available seats
    public int getAvailableSeats() {
        // Calculates available seats based on capacity and enrolled students.
        return capacity - enrolledStudents.size();
    }

    // Getters and Setters
    public ID getSectionID() {
        return sectionID;
    }

    public void setSectionID(ID sectionID) {
        this.sectionID = sectionID;
    }

    public List<SessionTime> getAllSessions() {
        return allSessions;
    }

    public void setAllSessions(List<SessionTime> allSessions) {
        this.allSessions = allSessions;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public CourseRegistrationSystem getCourseRegistrationSystem() {
        return courseRegistrationSystem;
    }

    public void setCourseRegistrationSystem(CourseRegistrationSystem courseRegistrationSystem) {
        this.courseRegistrationSystem = courseRegistrationSystem;
    }
}
