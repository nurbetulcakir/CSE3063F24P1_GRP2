import java.util.ArrayList;
public class CourseSection{
    // Attributes
    private int sectionID;
    private Course course; // Composition relationship with Course
    private ArrayList<Student> enrolledStudents = new ArrayList<Student>();
    private ArrayList<CourseSession> courseSessions = new ArrayList<CourseSession>();
    private int capacity;
    // Constructor
    
    public CourseSection(int sectionID, Course course, ArrayList<Student> enrolledStudents) {
        this.setSectionID(sectionID);
        this.setCourse(course); // Course is a required component for CourseSection (Composition)
        this.setCapacity(capacity);
        this.setEnrolledStudents(enrolledStudents); // Start as an empty list
    }
    
    public CourseSection(int sectionID, Course course, int capacity, ArrayList<CourseSession> courseSessions) {
        this.setSectionID(sectionID);
        this.setCourse(course); // Course is a required component for CourseSection (Composition)
        this.setCapacity(capacity);
        this.setCourseSessions(courseSessions);
    }
    
    public CourseSection(int sectionID, Course course, int capacity)  {
        this.setSectionID(sectionID);
        this.setCourse(course);
        this.setCapacity(capacity);
    }
    
    public CourseSection()  {
    }

    
    // This function is different from setEnrolledStudents, this adds one student to already exists list, other is making a new list from beginning.
    public void enrollStudent(Student student) {
    	enrolledStudents.add(student);
    }
    
	public int getSectionID() {
		return sectionID;
	}
	public void setSectionID(int sectionID) {
		this.sectionID = sectionID;
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
	public ArrayList<CourseSession> getCourseSessions() {
		return this.courseSessions;
	}
	public void setCourseSessions(ArrayList<CourseSession> courseSessions) {
		this.courseSessions = courseSessions;
	}
	
 }