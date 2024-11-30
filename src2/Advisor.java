import java.util.ArrayList;
public class Advisor extends Lecturer {
	
    // Attributes
	private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Student> awaitingStudents = new ArrayList<Student>();
    private Student advStudent;
    
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
		
		String courseId;
	    String courseName;
	    int courseTerm ;
	    double courseCredit;
	    		System.out.println("ID: " + this.getLecturerID().getId());
				System.out.println("First Name:" + this.getFirstName());
				System.out.println("Last Name:" + this.getLastName());
				System.out.println();
				System.out.println("Given Courses: ");
				System.out.printf("%-10s %-60s %-20s %-10s%n", "Course ID", "Course Name", "Course Term", "Course Credit");
		        System.out.println("---------------------------------------------------------------"
		        		+ "---------------------------------------------------------------");
				for(int j = 0; j < this.getGivenCourses().size(); j++) {
					courseId = this.getGivenCourses().get(j).getCourseID().getId();
				    courseName = this.getGivenCourses().get(j).getCourseName();
				    courseTerm = this.getGivenCourses().get(j).getCourseTerm();
				    courseCredit = this.getGivenCourses().get(j).getCourseCredit();

				    System.out.printf("%-10s %-60s %-20d %-10.1f%n", courseId, courseName, courseTerm, courseCredit);
					
					}
				System.out.println();
	    
	    }
	
	public void viewStudentList() {
		for (int i = 0; i < this.getStudentList().size();i++) {
				System.out.println("ID: " + this.getStudentList().get(i).getStudentID().getId()); 
				System.out.println("First Name: " + this.getStudentList().get(i).getFirstName());
				System.out.println("Last Name: " + this.getStudentList().get(i).getLastName() + "\n");
		}
	}
	
    public void selectNextStudent(int index) {
        this.setAdvStudent(getAwaitingStudents().get(index - 1));
    }
	
	
    public void findAwaitingStudents() {
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (!awaitingStudents.contains(student) && student.getApproveRequest() == 1) {
                awaitingStudents.add(student);
            }           
        }
    }
    
	private void removeAwaitingStudent(Student s) {
        this.awaitingStudents.remove(awaitingStudents.indexOf(s));
    }
	

	public void approveCourses() {
		ArrayList<CourseSection> selectCourse = this.advStudent.getChosenCourses();
        for(int i = 0 ; i < selectCourse.size(); i++) {
            CourseSection courseSec = selectCourse.get(i);
            this.advStudent.AddToApprovedCourses(courseSec);
            courseSec.enrollStudent(this.advStudent);
        }
        this.advStudent.setChosenCourses(null);
        this.advStudent.setApproveRequest(2);
        this.removeAwaitingStudent(this.advStudent);
        this.setAdvStudent(null);
	}
	
	public void disapproveCourses() {
		 ArrayList<CourseSection> selectCourse = this.advStudent.getChosenCourses();
	        for(int i = 0 ; i < selectCourse.size(); i++) {
	            CourseSection courseSec = selectCourse.get(i);
	            courseSec.setCapacity(courseSec.getCapacity() + 1);
	        }
	        this.advStudent.setChosenCourses(null);
	        this.advStudent.setApproveRequest(3);
	        this.removeAwaitingStudent(this.advStudent);
	        this.setAdvStudent(null);
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

	public Student getAdvStudent() {
		return advStudent;
	}

	public void setAdvStudent(Student advStudent) {
		this.advStudent = advStudent;
	}
}