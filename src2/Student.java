import java.util.ArrayList;

public class Student extends Person {
    // Attributes
    private ID studentID;
    private Advisor advisor;
    private Transcript transcript;
    private int term;
    private ArrayList<CourseSection> chosenCourses; // Course Section, because student chooses section on registration system
    private ArrayList<CourseSection> approvedCourses = new ArrayList<CourseSection>();
    private int approveRequest = 0; // 0 if not send for approval, 1 if send for approval, 2 if approved, 3 if disapproved
    private ArrayList<String> unreadNotifications;
    private ArrayList<String> readNotifications;
    

	// Constructor
    public Student(ID studentID, String firstName, String lastName, Password password,
    		Advisor advisor, int term) {
        super(firstName, lastName, password);
        this.setStudentID(studentID);
        this.setAdvisor(advisor);
        this.setTerm(term);
    }
    
    public Student(ID studentID, String firstName, String lastName, Password password,
    		Advisor advisor, int term, ArrayList<Course> passedCourses, ArrayList<Course> failedCourses,
    		ArrayList<CourseSection> chosenCourses, ArrayList<CourseSection> approvedCourses) {
        super(firstName, lastName, password);
        this.setStudentID(studentID);
        this.setAdvisor(advisor);
        this.setTerm(term);
        this.setChosenCourses(chosenCourses);
        this.setApprovedCourses(approvedCourses);
    }
    
    public Student(ID studentID) {
    	this.setStudentID(studentID);
    }

   public void addChosenCourse(CourseSection cs) {
	   this.chosenCourses.add(cs); 
   }
   
   public void removeChosenCourse(CourseSection cs) {
	   this.chosenCourses.remove(cs);
   }
  

   public void addToApprovedCourses(CourseSection cs) {
	   this.approvedCourses.add(cs);
   }
   

   
   public String viewSchedule() {
//	   String schedule = "";
//	   for(int i = 0; i < this.chosenCourses.size(); i++) {
//		   schedule.concat("Course Name:" + this.chosenCourses.get(i).getCourse().getCourseName() + ", Course Section No: " + this.chosenCourses.get(i).getSectionID() +
//	   				", Section Hours: " + this.chosenCourses.get(i).getAllSessions().get(i).getStartTime() + " - " + this.chosenCourses.get(i).getAllSessions().get(i).getEndTime() + "\n");		
//	   }
	   return "";
   }
   
   public void addNotification(String message) {
	    this.unreadNotifications.add(message);
	}

	public void notificationsSeen() {
		if(readNotifications == null) {
			readNotifications = new ArrayList<String>();
	    this.readNotifications.addAll(unreadNotifications);
		}
		else {
			this.readNotifications.addAll(unreadNotifications);
		}
	    this.unreadNotifications.clear();
	}
   
   public void sendForApproval() {
	   this.approveRequest = 1;
	   Advisor advisor = this.getAdvisor();
	    if (advisor == null) {
	        System.out.println("No advisor assigned to you. Please contact the administration.");
	        return;
	      }
	    if (advisor.getAwaitingStudents() == null) {
	    advisor.setAwaitingStudents(new ArrayList<Student>());
	    }
	    advisor.getAwaitingStudents().add(this);
	    if (advisor.getReadNotifications() == null) {
	    	advisor.setReadNotifications(new ArrayList<String>());
	    }
	    if (advisor.getUnreadNotifications() == null) {
	    	advisor.setUnreadNotifications(new ArrayList<String>());
	    }
	    advisor.addNotification(this.getFirstName() + " " + this.getLastName() + " is waiting for your registration approve.");
   }

	public ID getStudentID() {
		return studentID;
	}

	public void setStudentID(ID studentID) {
		this.studentID = studentID;
	}

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}


	public ArrayList<CourseSection> getChosenCourses() {
		return chosenCourses;
	}

	public void setChosenCourses(ArrayList<CourseSection> chosenCourses) {
		this.chosenCourses = chosenCourses;
	}

	public ArrayList<CourseSection> getApprovedCourses() {
		return approvedCourses;
	}

	public void setApprovedCourses(ArrayList<CourseSection> approvedCourses) {
		this.approvedCourses = approvedCourses;
	}

	public int getApproveRequest() {
		return approveRequest;
	}

	public void setApproveRequest(int approveRequest) {
		this.approveRequest = approveRequest;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}
	
    public ArrayList<String> getUnreadNotifications() {
    	if(unreadNotifications == null) {
    		unreadNotifications = new ArrayList<String>();
		return unreadNotifications;
    	}
    	else {
    		return readNotifications;
    	}
	}

	public void setUnreadNotifications(ArrayList<String> unreadNotifications) {
		this.unreadNotifications = unreadNotifications;
	}


    public ArrayList<String> getReadNotifications() {
    	if(readNotifications == null) {
    		readNotifications = new ArrayList<String>();
		return readNotifications;
    	}
    	else {
    		return readNotifications;
    	}
	}

	public void setReadNotifications(ArrayList<String> readNotifications) {
		this.readNotifications = readNotifications;
	}
	
   }