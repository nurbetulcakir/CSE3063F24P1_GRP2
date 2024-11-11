import java.util.ArrayList;

public class CourseSection {
    // Attributes
    private int sectionID;
    private ArrayList<SessionTime> allSessions = new ArrayList<SessionTime>();
    private Course course; // Composition relationship with Course
    private ArrayList<Student> enrolledStudents = new ArrayList<Student>();
    private int capacity;

    // Constructor
    public CourseSection(int sectionID, Course course, int capacity) {
        super();
        this.setSectionID(sectionID);
        this.setCourse(course); // Course is a required component for CourseSection (Composition)
        this.setCapacity(capacity);
        this.setAllSessions(new ArrayList<>()); // Start as an empty list
        this.setEnrolledStudents(new ArrayList<>()); // Start as an empty list
    }

    // Method to get available seats
    public int getAvailableSeats() {
        return this.capacity - this.enrolledStudents.size(); // Returns remaining available seats
    }

    // Method to enroll a student
    public boolean enrollStudent(Student student) {
        if (this.enrolledStudents.size() < this.capacity) {
            this.enrolledStudents.add(student);
            return true; // Successfully enrolled
        }
        return false; // Capacity is full
    }

    // Method to drop a student
    public boolean dropStudent(Student student) {
        return this.enrolledStudents.remove(student); // Returns true if student was removed
    }

    // Method to add a session
    public void addSession(SessionTime session) {
        this.allSessions.add(session); // Adds the session to the list of sessions
    }

    // Getters and Setters
    public int getSectionID() {
        return sectionID;
    }

    public void setSectionID(int sectionID) {
        this.sectionID = sectionID;
    }

    public ArrayList<SessionTime> getAllSessions() {
        return allSessions;
    }

    public void setAllSessions(ArrayList<SessionTime> allSessions) {
        this.allSessions = allSessions;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(ArrayList<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
