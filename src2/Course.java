import java.util.ArrayList;
public class Course {
    // Attributes
    private ID courseID;
    private String courseName;
    private ArrayList<Course> prerequisiteCourse = new ArrayList<Course>();
    private int courseTerm; // it can be taken after that term, before is not allowed
    private double courseCredit;
    private Advisor advisor;
    
    // Constructor
    public Course(ID courseID, String courseName, ArrayList<Course> prerequisiteCourse, int courseTerm, double courseCredit, Advisor advisor) {
        this.setCourseID(courseID);
        this.setCourseName(courseName);
        this.setPrerequisiteCourse(prerequisiteCourse);
        this.setCourseTerm(courseTerm);
        this.setCourseCredit(courseCredit);
        this.setAdvisor(advisor);
    }
    
    public Course(ID courseID, String courseName, ArrayList<Course> prerequisiteCourse) {
        this.setCourseID(courseID);
        this.setCourseName(courseName);
        this.prerequisiteCourse = new ArrayList<>(); // Start as an empty list
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
	
	public ArrayList<Course> getPrerequisiteCourse(){
		return this.prerequisiteCourse;
	}
	public void setPrerequisiteCourse(ArrayList<Course> prerequisiteCourse){
		this.prerequisiteCourse = prerequisiteCourse;
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

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

    
    
    
}