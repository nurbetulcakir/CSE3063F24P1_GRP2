import java.util.ArrayList;
public class Advisor extends Lecturer {
	
    // Attributes
	private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Student> awaitingStudents = new ArrayList<Student>();
    
    // Constructor
    public Advisor(ID lecturerID, String firstName, String lastName, Password password, ArrayList<Student> studentList, ArrayList<Student> awaitingStudents) {
        super(lecturerID,firstName,lastName);
        this.setStudentList(studentList);
        this.setAwaitingStudents(awaitingStudents);
    }
    
    public Advisor(ID lecturerID, String firstName, String lastName) {
        super(lecturerID,firstName,lastName);
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
	
	public boolean approveCourses(Student student, Advisor advisor) {
		// Check if the student is assigned to the advisor
		if (!advisor.getStudentList().contains(student)) {
			return false;
		}
	
		// Check if the student is in the awaitingStudents list
		if (!advisor.getAwaitingStudents().contains(student)) {
			return false;
		}
	
		// Approve each chosen course and move it to the approvedCourses list
		for (CourseSection courseSection : student.getChosenCourses()) {
			student.getApprovedCourses().add(courseSection);
		}
	
		student.getChosenCourses().clear();
		advisor.getAwaitingStudents().remove(student);
	
		return true;
	}
	
	public void disapproveCourses(Student student) {
		student.getAdvisor().getAwaitingStudents().remove(student);
		student.getChosenCourses().clear();
		System.out.println("Courses not approved for student: " + student.getStudentID());
	}

	public ArrayList<Student> getAwaitingStudents() {
		return awaitingStudents;
	}
	public void setAwaitingStudents(ArrayList<Student> awaitingStudents) {
		this.awaitingStudents = awaitingStudents;
	}
}