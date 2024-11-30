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
		for (int i = 0; i < ObjectCreator.advisors.size(); i++) {
	    		System.out.println("ID: " + ObjectCreator.advisors.get(i).getLecturerID().getId());
				System.out.println("First Name:" + ObjectCreator.advisors.get(i).getFirstName());
				System.out.println("Last Name:" + ObjectCreator.advisors.get(i).getLastName());
				System.out.println();
				System.out.println("Given Courses: ");
				System.out.printf("%-10s %-60s %-20s %-10s%n", "Course ID", "Course Name", "Course Term", "Course Credit");
		        System.out.println("---------------------------------------------------------------"
		        		+ "---------------------------------------------------------------");
				for(int j = 0; j < ObjectCreator.advisors.get(i).getGivenCourses().size(); j++) {
					courseId = ObjectCreator.advisors.get(i).getGivenCourses().get(j).getCourseID().getId();
				    courseName = ObjectCreator.advisors.get(i).getGivenCourses().get(j).getCourseName();
				    courseTerm = ObjectCreator.advisors.get(i).getGivenCourses().get(j).getCourseTerm();
				    courseCredit = ObjectCreator.advisors.get(i).getGivenCourses().get(j).getCourseCredit();

				    System.out.printf("%-10s %-60s %-20d %-10.1f%n", courseId, courseName, courseTerm, courseCredit);
					
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
	
	public void approveCourses() {
		ArrayList<CourseSection> selectCourse = this.advStudent.getChosenCourses();
        for(int i = 0 ; i < selectCourse.size(); i++) {
            CourseSection courseSec = selectCourse.get(i);
            this.advStudent.AddToApprovedCourses(courseSec);
            courseSec.enrollStudent(this.advStudent);
        }
        this.advStudent.setChosenCourses(null);
        this.advStudent.setApproveRequest(1);
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
	        this.advStudent.setApproveRequest(0);
	        this.removeAwaitingStudent(this.advStudent);
	        this.setAdvStudent(null);
	}
	
	
//    public void sendNotification(String message, String type) {
//        
//        String sendMessage = "";
//        if (message.isEmpty()) {
//            if(type.equals("A")) {
//                sendMessage = "The request is approved!";
//            }
//            else {
//                sendMessage = "The request is disapproved!";
//            }
//        }
//        else {
//            sendMessage = message;
//        }
//        
//        this.advStudent.addUnreadNotification(sendMessage);
//    }
//	
	private void removeAwaitingStudent(Student s) {
        this.awaitingStudents.remove(awaitingStudents.indexOf(s));
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