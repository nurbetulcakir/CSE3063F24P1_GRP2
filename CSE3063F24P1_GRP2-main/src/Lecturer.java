import java.util.ArrayList;
public class Lecturer extends Person{
	private ID lecturerID;
	private ArrayList<Course> givenCourses = new ArrayList<Course>();
	
	public Lecturer(ID lecturerID, String firstName, String lastName) {
		super(firstName, lastName);
		
	}
	public ID getLecturerID() {
		return lecturerID;
	}
	public void setLecturerID(ID lecturerID) {
		this.lecturerID = lecturerID;
	}
	
	public ArrayList<Course> getGivenCourses() {
		return givenCourses;
	}
	public void setGivenCourses(ArrayList<Course> givenCourses) {
		this.givenCourses = givenCourses;
	}
	
}
