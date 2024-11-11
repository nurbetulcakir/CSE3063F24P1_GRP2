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
		for (int i = 0; i < ObjectCreator.advisors.size(); i++) {
	    		System.out.println("ID: " + ObjectCreator.advisors.get(i).getLecturerID().getId());
				System.out.println("First Name:" + ObjectCreator.advisors.get(i).getFirstName());
				System.out.println("Last Name:" + ObjectCreator.advisors.get(i).getLastName());
				System.out.println();
				System.out.println("Given Courses: ");
				for(int j = 0; j < ObjectCreator.advisors.get(i).getGivenCourses().size(); j++) {
					System.out.println("Course ID: " + ObjectCreator.advisors.get(i).getGivenCourses().get(j).getCourseID().getId());
					System.out.println("Course Name: " + ObjectCreator.advisors.get(i).getGivenCourses().get(j).getCourseName());
					System.out.println("Course Term: " + ObjectCreator.advisors.get(i).getGivenCourses().get(j).getCourseTerm());
					System.out.println("Course Credit: " + ObjectCreator.advisors.get(i).getGivenCourses().get(j).getCourseCredit());
				}
				System.out.println();
	    		break;
	    
	    }
	}
	public void viewStudentList() {
		for (int i = 0; i < ObjectCreator.students.size();i++) {
				System.out.println("ID: " + ObjectCreator.students.get(i).getStudentID().getId()); 
				System.out.println("First Name: " + ObjectCreator.students.get(i).getFirstName());
				System.out.println("Last Name: " + ObjectCreator.students.get(i).getLastName() + "\n");
		}
	}
	
    
	public ArrayList<Student> getStudentList() {
		return studentList;
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