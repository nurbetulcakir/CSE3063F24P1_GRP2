import java.util.ArrayList;

public class Student extends Person {
    // Attributes
    private ID studentID;
    private Advisor advisor;
    private ArrayList<Course> passedCourses = new ArrayList<Course>();
    private ArrayList<Course> failedCourses = new ArrayList<Course>();
    private ArrayList<CourseSection> choosableCourses = new ArrayList<CourseSection>();
    private ArrayList<CourseSection> chosenCourses = new ArrayList<CourseSection>();
    private ArrayList<CourseSection> approvedCourses = new ArrayList<CourseSection>();
    private ArrayList<CourseSection> disapprovedCourses = new ArrayList<CourseSection>();
    private String courseLetterGrade;
	private int term;
	private int regRequest = 0; // 1 when send
	private ArrayList<String> letterGrade = new ArrayList<String>();

    
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
    		Advisor advisor, ArrayList<Course> passedCourses, ArrayList<Course> failedCourses,
    		ArrayList<CourseSection> choosableCourses, ArrayList<CourseSection> chosenCourses,
    		ArrayList<CourseSection> approvedCourses, ArrayList<CourseSection> disapprovedCourses, int term) {
        super(firstName, lastName, password);
        this.setStudentID(studentID);
        this.setAdvisor(advisor);
        this.setPassedCourses(passedCourses);
        this.setFailedCourses(failedCourses);
        this.setChoosableCourses(choosableCourses);
        this.setChosenCourses(chosenCourses);
        this.setApprovedCourses(approvedCourses);
        this.setDisapprovedCourses(disapprovedCourses);
        this.setTerm(term);
    }
    
    public Student(ID studentID, String firstName, String lastName) {
    	super(firstName, lastName);
    	this.setStudentID(studentID);
    }
    
   public boolean isPrerequisiteCoursesPassed(Course course) {
    	
    	boolean isPassed= false;

    	
		return isPassed;
    }
   
   
   public void initLetterGrade(Course course, String letterGrade){
	   if(this.passedCourses.contains(course)) {
	   this.letterGrade.add(this.getPassedCourses().indexOf(course), letterGrade);
	   }
	   else if(this.failedCourses.contains(course)) {
	   this.letterGrade.add(this.getFailedCourses().indexOf(course), letterGrade);
	   }
	   
   }
   
   
   public String viewSchedule() {
	   
	   
	   
	   return "";
   }
   
   public void sendForApproval() {
   this.setRegRequest(1);
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

	public ArrayList<Course> getPassedCourses() {
		return passedCourses;
	}

	public void setPassedCourses(ArrayList<Course> passedCourses) {
		this.passedCourses = passedCourses;
	}
	
	public ArrayList<Course> getFailedCourses() {
		return failedCourses;
	}
	public void setFailedCourses(ArrayList<Course> failedCourses) {
		this.failedCourses = failedCourses;
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

	public ArrayList<CourseSection> getDisapprovedCourses() {
		return disapprovedCourses;
	}

	public void setDisapprovedCourses(ArrayList<CourseSection> disapprovedCourses) {
		this.disapprovedCourses = disapprovedCourses;
	}

	public ArrayList<CourseSection> getChoosableCourses() {
		return choosableCourses;
	}

	public void setChoosableCourses(ArrayList<CourseSection> choosableCourses) {
		this.choosableCourses = choosableCourses;
	}

	public int getRegRequest() {
		return regRequest;
	}

	public void setRegRequest(int regRequest) {
		this.regRequest = regRequest;
	}

	public String getCourseLetterGrade() {
		return courseLetterGrade;
	}

	public void setCourseLetterGrade(String courseLetterGrade) {
		this.courseLetterGrade = courseLetterGrade;
	}

	public String getLetterGrade(Course course) {
		if (this.passedCourses.contains(course)) {
			return this.letterGrade.get(this.getPassedCourses().indexOf(course));
		}
		else if (this.failedCourses.contains(course)){
			return this.letterGrade.get(this.getFailedCourses().indexOf(course));
			
		}
		
		return null;
	}

	public void setLetterGrade(ArrayList<String> letterGrade) {
		this.letterGrade = letterGrade;
	}

   }