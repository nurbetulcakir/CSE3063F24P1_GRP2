import java.util.ArrayList;
public class Lecturer extends Person{
	private ID lecturerID;
	private ArrayList<Course> givenCourses = new ArrayList<Course>();
	
	public Lecturer(ID lecturerID, String firstName, String lastName, ArrayList<Course> givenCourses) {
		super(firstName, lastName);
		this.setLecturerID(lecturerID);
		this.setGivenCourses(givenCourses);
	}
	
	public Lecturer(ID lecturerID, String firstName, String lastName) {
		super(firstName,lastName);
		this.setLecturerID(lecturerID);

	}
	public Lecturer(ID lecturerID)  {
		this.setLecturerID(lecturerID);
	}
	
	
	
	@Override
	public void viewSchedule() {
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Lecturer ID: " + this.getLecturerID() + ", Lecturer Name: " + this.getFirstName() + " " + this.getLastName());
			System.out.println("Days: ");
			
			
		}
		
		
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
