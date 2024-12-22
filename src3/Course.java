import java.util.ArrayList;
public class Course {
    // Attributes
    private ID courseID;
    private String courseName;
    private ArrayList<Course> prerequisiteCourse = new ArrayList<Course>();
    private ArrayList<CourseSection> courseSections = new ArrayList<CourseSection>();
    private int courseTerm;
    private double courseCredit;
    private String courseLetterGrade;
    // Constructor
    public Course(ID courseID, String courseName, int courseTerm, double courseCredit, String courseLetterGrade, ArrayList<Course> prerequisiteCourse) {
        this.setCourseID(courseID);
        this.setCourseName(courseName);
        this.prerequisiteCourse = new ArrayList<>();
        this.courseTerm = courseTerm;
        this.courseCredit = courseCredit;
        this.courseLetterGrade = courseLetterGrade;
    }
    
    public Course(ID courseID, String courseName, int courseTerm, double courseCredit, ArrayList<Course> prerequisiteCourse) {
        this.setCourseID(courseID);
        this.setCourseName(courseName);
        this.prerequisiteCourse = new ArrayList<>(); // Start as an empty list
        this.courseTerm = courseTerm;
        this.courseCredit = courseCredit;
    }
    
    public Course(ID courseID, String courseName, ArrayList<Course> prerequisiteCourse) {
        this.setCourseID(courseID);
        this.setCourseName(courseName);
        this.prerequisiteCourse = new ArrayList<>(); // Start as an empty list
    }
    
    public Course(ID courseID, String courseName)  {
        this.setCourseID(courseID);
        this.setCourseName(courseName);
    }
    public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(int sectionID, Course course, int capacity) {
		// TODO Auto-generated constructor stub
	}

	// Method to add a prerequisite course
    public void addPrerequisiteCourse(Course course) {
        // Adds a course to the list of prerequisites.
        this.prerequisiteCourse.add(course);
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
	
	public ArrayList<Course> viewPrerequisiteCourses(){
		return this.prerequisiteCourse;
	}
	public int getCourseTerm() {
		return courseTerm;
	}
	public void setCourseTerm(int courseTerm) {
		this.courseTerm = courseTerm;
	}
	public double getCourseCredit() {
		return courseCredit;
	}
	public void setCourseCredit(double courseCredit) {
		this.courseCredit = courseCredit;
	}

	public String getCourseLetterGrade() {
		return courseLetterGrade;
	}

	public void setCourseLetterGrade(String courseLetterGrade) {
		this.courseLetterGrade = courseLetterGrade;
	}

	public ArrayList<CourseSection> getCourseSections() {
		return courseSections;
	}

	public void setCourseSections(ArrayList<CourseSection> courseSections) {
		this.courseSections = courseSections;
	}

	public Course[] getPrerequisiteCourse() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
    
}