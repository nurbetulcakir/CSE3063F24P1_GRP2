import java.util.ArrayList;
public class CourseSection{
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
    public CourseSection() {
    	
    }
    
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