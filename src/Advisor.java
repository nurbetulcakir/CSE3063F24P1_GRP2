import java.util.List;

public class Advisor extends Person {
	
	private List<Student> assignedStudents;
	private List<Student> awaitingStudents;
	
	 private String firstName;
	 private String lastName;
	 private int lecturerID;
	 private String password;
	
	 public Advisor(String firstName, String lastName, int lecturerID, String password) {
		 
		 	super(firstName, lastName);
		    this.firstName = firstName;
		    this.lastName = lastName;
		    this.lecturerID = lecturerID;
		    this.password = password;   
		 
	}
	 
	public List<Student> viewAssignedStudents() {
		 return ;
	}
	public List<Student> viewAwaitingStudents() {
		return ;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getLecturerID() {
		return lecturerID;
	}

	public void setLecturerID(int lecturerID) {
		this.lecturerID = lecturerID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	 
	
	 
	 
	 
	
}
