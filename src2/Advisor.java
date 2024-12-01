import java.util.ArrayList;
public class Advisor extends Lecturer {
	
    // Attributes
	private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Student> awaitingStudents;
    private Student advStudent;
    private ArrayList<String> unreadNotifications = new ArrayList<String>();

	// Constructor
    public Advisor(ID lecturerID, String firstName, String lastName, Password password, ArrayList<Student> studentList, ArrayList<Student> awaitingStudents) {
        super(lecturerID,firstName,lastName);
        this.setStudentList(studentList);
        this.setAwaitingStudents(awaitingStudents);
    }
    
    public Advisor(ID lecturerID) {
        super(lecturerID);
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
            this.advStudent.addToApprovedCourses(courseSec);
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
	
    public void sendNotification(String message, int req) {
        
        String sendMessage = "";
        if (message.isEmpty()) {
            if(req == 2) {
                sendMessage = "The request is approved!";
            }
            else if (req == 3) {
                sendMessage = "The request is disapproved!";
            }
        }
        else {
            sendMessage = message;
        }
        
        this.advStudent.addNotification(sendMessage);
    }
	
    public void addNotification(String message) {
	    this.unreadNotifications.add(message);
	}

	public void notificationsSeen() {
	    this.readNotifications.addAll(unreadNotifications);
	    this.unreadNotifications.clear();
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

	public ArrayList<Course> getGivenCourses() {
		// TODO Auto-generated method stub
		return super.getGivenCourses();
	}
	
    public ArrayList<String> getUnreadNotifications() {
		return unreadNotifications;
	}

	public void setUnreadNotifications(ArrayList<String> unreadNotifications) {
		this.unreadNotifications = unreadNotifications;
	}

	private ArrayList<String> readNotifications = new ArrayList<String>();
    
    public ArrayList<String> getReadNotifications() {
		return readNotifications;
	}

	public void setReadNotifications(ArrayList<String> readNotifications) {
		this.readNotifications = readNotifications;
	}
}