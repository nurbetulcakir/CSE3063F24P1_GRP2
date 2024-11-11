import java.util.ArrayList;

public class Student extends Person {
    // Attributes
    private ID studentID;
    private Advisor advisor;
    private int term;
    private ArrayList<Course> passedCourses = new ArrayList<Course>();
    private ArrayList<CourseSection> chosenCourses = new ArrayList<CourseSection>();
    private ArrayList<CourseSection> approvedCourses = new ArrayList<CourseSection>();
    
    // Constructor
    public Student(ID studentID, String firstName, String lastName, Password password,
    		Advisor advisor, int term, ArrayList<Course> passedCourses) {
        super(firstName, lastName, password);
        this.setStudentID(studentID);
        this.setAdvisor(advisor);
        this.setTerm(term);
        this.setPassedCourses(passedCourses); // Start as an empty list
    }
    
    public Student(ID studentID, String firstName, String lastName, Password password,
    		Advisor advisor, int term, ArrayList<Course> passedCourses, ArrayList<CourseSection> chosenCourses,
    		ArrayList<CourseSection> approvedCourses) {
        super(firstName, lastName, password);
        this.setStudentID(studentID);
        this.setAdvisor(advisor);
        this.setTerm(term);
        this.setPassedCourses(passedCourses);
        this.setChosenCourses(chosenCourses);
        this.setApprovedCourses(approvedCourses);
    }
    
    public Student(ID studentID, String firstName, String lastName) {
    	super(firstName, lastName);
    	this.setStudentID(studentID);
    }
    
   public boolean isPrerequisiteCoursesPassed(Course course) {
    	
    	boolean isPassed= false;
    	int temp = 0;
    	
    	for(int i = 0; i < course.viewPrerequisiteCourses().size(); i++) {
    		
    	if (this.passedCourses.contains(course.viewPrerequisiteCourses().get(i))){
    		temp++;
    		
    		}
    	}
    	
	    	if (temp == course.viewPrerequisiteCourses().size()) {
	    		isPassed = true;
	    	}
	    	else {
	    		isPassed = false;
	    	}
    	
		return isPassed;
    }
   
   public String viewSchedule() {
   	
   	String schedule = "";
   	for(int i = 0; i < this.chosenCourses.size(); i++) {
   		
   		schedule.concat("Course Name:" + this.chosenCourses.get(i).getCourse().getCourseName() + ", Course Section No: " + this.chosenCourses.get(i).getSectionID() +
   				", Section Hours: " + this.chosenCourses.get(i).getAllSessions().get(i).getStartTime() + " -" + this.chosenCourses.get(i).getAllSessions().get(i).getEndTime() + "\n");
       
   		}
   	
		return null;
   }
   
   public void sendToApprove() {
   	// later
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
	
	public void viewAdvisor() {
		System.out.println("Advisor Details:");
        System.out.println("First Name: " + this.getAdvisor().getFirstName());
        System.out.println("Last Name: " + this.getAdvisor().getLastName());
        System.out.println("Given Courses:");
        for (int i = 0; i < this.getAdvisor().getGivenCourses().size(); i++) {
        	System.out.println(this.getAdvisor().getGivenCourses().get(i).getCourseName());
        }
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public ArrayList<Course> getPassedCourses() {
		return passedCourses;
	}

	public void setPassedCourses(ArrayList<Course> passedCourses) {
		this.passedCourses = passedCourses;
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

   }