import java.util.ArrayList;
public class Advisor extends Lecturer {
	
    // Attributes
	private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Student> awaitingStudents = new ArrayList<Student>();
    private ID advisorID;
    
    // Constructor
    public Advisor(ID lecturerID, String firstName, String lastName, Password password) {
        super(lecturerID,firstName,lastName);
        this.setStudentList(new ArrayList<>()); // Start as an empty list
       // this.setAwaitingStudents(new ArrayList<>()); // Start as an empty list
    }
	
	public void ViewAdvisorInfo() {
		
		for (int i = 0; i < ObjectCreator.advisors.size();i++) {
			if (advisorID == ObjectCreator.advisors.get(i).getLecturerID()) {
				System.out.println("Id:" + ObjectCreator.advisors.get(i).getLecturerID()); 
				System.out.println("First Name:" + ObjectCreator.advisors.get(i).getFirstName());
				System.out.println("Last Name:" + ObjectCreator.advisors.get(i).getLastName() + "\n");
				
			}
		}
		
	}
	
	public void getStudentList() {
		
		for (int i = 0; i < ObjectCreator.students.size();i++) {
			if (this.advisorID == ObjectCreator.students.get(i).getAdvisor().getLecturerID()) {
				System.out.println("Id:" + ObjectCreator.students.get(i).getStudentID()); 
				System.out.println("First Name:" + ObjectCreator.students.get(i).getFirstName());
				System.out.println("Last Name:" + ObjectCreator.students.get(i).getLastName() + "\n");
			}
		}
		
	}
	
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	public void ApproveDisapproveCourses() {
		// TODO Auto-generated method stub
		
	}
	
	
	public ID getAdvisorID() {
		return advisorID;
	}
	public void setAdvisorID(ID advisorID) {
		this.advisorID = advisorID;
	}

	public ArrayList<Student> getAwaitingStudents() {
		return awaitingStudents;
	}

	public void setAwaitingStudents(ArrayList<Student> awaitingStudents) {
		this.awaitingStudents = awaitingStudents;
	}
}