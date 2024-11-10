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
    	super(lastName, lastName);
    	this.setStudentID(studentID);
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
        System.out.println("GPA: " + "");
        System.out.println("CGPA: " + "");
        System.out.println("Credits Received: " + "");
        System.out.println("Credits Earned: " + "");
        System.out.println("Total Credits Received: " + "");
        System.out.println("Total Credits Earned: " + "");
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