import java.util.ArrayList;
public class Advisor extends Lecturer {
    // Attributes
    private static ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Student> awaitingStudents = new ArrayList<Student>();
    private ID advisorID;
    // Constructor
    public Advisor(ID lecturerID, String firstName, String lastName, Password password) {
        super(lecturerID,firstName,lastName);
        this.setStudentList(new ArrayList<>()); // Start as an empty list
        this.setAwaitingStudents(new ArrayList<>()); // Start as an empty list
    }
	public static ArrayList<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(ArrayList<Student> studentList) {
		Advisor.studentList = studentList;
	}
	public ArrayList<Student> getAwaitingStudents() {
		return awaitingStudents;
	}
	public void setAwaitingStudents(ArrayList<Student> awaitingStudents) {
		this.awaitingStudents = awaitingStudents;
	}
	
	public static void ApproveDisapproveCourses() {
		// TODO Auto-generated method stub
		
	}
	public void ViewAdvisorInfo() {
		// TODO Auto-generated method stub
		
	}
	public ID getAdvisorID() {
		return advisorID;
	}
	public void setAdvisorID(ID advisorID) {
		this.advisorID = advisorID;
	}
	
}