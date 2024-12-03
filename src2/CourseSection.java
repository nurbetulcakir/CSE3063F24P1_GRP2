import java.util.ArrayList;
public class CourseSection extends Course{
    // Attributes
    private int sectionID;
    private Course course; // Composition relationship with Course
    private ArrayList<Student> enrolledStudents = new ArrayList<Student>();
    private int capacity;
    
	private String day;
	private String startTime;
	private String endTime;
	private String classroom;
	private Object courseSessions;
	
    // Constructor
    
    public CourseSection(int sectionID, Course course, ArrayList<Student> enrolledStudents) {
        super(course.getCourseID(), course.getCourseName());
        this.setSectionID(sectionID);
        this.setCourse(course); // Course is a required component for CourseSection (Composition)
        this.setCapacity(capacity);
        this.setEnrolledStudents(enrolledStudents); // Start as an empty list
    }
    
    public CourseSection(int sectionID, Course course, int capacity, ArrayList<CourseSection> courseSections) {
        super(course.getCourseID(), course.getCourseName());
    	this.setSectionID(sectionID);
        this.setCourse(course); // Course is a required component for CourseSection (Composition)
        this.setCapacity(capacity);
        
    }
    
    public CourseSection(int sectionID, Course course, int capacity)  {
        super(course.getCourseID(), course.getCourseName());
        this.setSectionID(sectionID);
        this.setCourse(course);
        this.setCapacity(capacity);
    }
    
    public CourseSection(int sectionID, Course course, int capacity, String day, String startTime, String endTime, String classroom) {
    	super(sectionID, course, capacity);
    	this.setDay(day);
    	this.setStartTime(startTime);
    	this.setEndTime(endTime);
    	this.setClassroom(classroom);
    }
    
    public CourseSection(String day, String startTime, String endTime, String classroom)  {
    	this.setDay(day);
    	this.setStartTime(startTime);
    	this.setEndTime(endTime);
    	this.setClassroom(classroom);
    }
    
    public CourseSection()  {
        super();
    }
    
    // Method to check if the section time is valid
    public boolean isValidSection() {
        // Checks if startDateTime is before endDateTime
    	return true; //startDateTime.isBefore(endDateTime);
    }
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
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
		this.setCourseSessions(new ArrayList<CourseSession>());

		// TODO Auto-generated method stub
		return this.getCourseSessions();
	}

	public void setCourseSessions(ArrayList<CourseSession> courseSessions) {
		this.courseSessions = courseSessions;
	}
 }