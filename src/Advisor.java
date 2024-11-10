import java.util.ArrayList;

public class Advisor extends Lecturer {
    // Attributes
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Student> awaitingStudents = new ArrayList<Student>();
    // Constructor
    public Advisor(ID lecturerID, String firstName, String lastName, Password password) {
        super(lecturerID,firstName,lastName);
        this.setStudentList(new ArrayList<>()); // Start as an empty list
        this.setAwaitingStudents(new ArrayList<>()); // Start as an empty list
    }
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	public ArrayList<Student> getAwaitingStudents() {
		return awaitingStudents;
	}
	public void setAwaitingStudents(ArrayList<Student> awaitingStudents) {
		this.awaitingStudents = awaitingStudents;
	}

   
	 
	
	 
	 
	 
	
}
