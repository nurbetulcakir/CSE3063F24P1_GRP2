import java.util.ArrayList;
import java.util.List;

public class Course {
	
	private ID courseID;
	private String courseName;
	private List<Course> prerequisites;
	public CourseRegistrationSystem courseRegistrationSystem;
	
	private Lecturer lecturer;
	private ArrayList<Course> prerequisiteCourses = new ArrayList<>();
	private ArrayList<Student> takenStudentList = new ArrayList<>();
	private int courseHour;
	private int courseCredit;
	
	
	public Course(int courseID, String courseName, Lecturer lecturer, int courseHour, int courseCredit) {
		this.courseID = courseID;
		this.courseName = courseName;
		this.lecturer = lecturer;
		this.courseHour = courseHour;
		this.courseCredit = courseCredit;
}

	public void addPrerequisite(Course course) {
		
	}
	
	
	
	
	
	
	
	public int getCourseID() {
		return courseID;
	}
	
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public Lecturer getLecturer() {
		return lecturer;
	}
	
	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}
	
	public ArrayList<Course> getPrerequisiteCourses() {
		return prerequisiteCourses;
	}
	
	public void setPrerequisiteCourses(ArrayList<Course> prerequisiteCourses) {
		this.prerequisiteCourses = prerequisiteCourses;
	}
	
	public ArrayList<Student> getTakenStudentList() {
		return takenStudentList;
	}
	
	public void setTakenStudentList(ArrayList<Student> takenStudentList) {
		this.takenStudentList = takenStudentList;
	}
	
	public int getCourseHour() {
		return courseHour;
	}
	
	public void setCourseHour(int courseHour) {
		this.courseHour = courseHour;
	}
	
	public int getCourseCredit() {
		return courseCredit;
	}
	
	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}
	

	
	
	

}
