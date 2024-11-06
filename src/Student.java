import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
	
	private Advisor advisor;
	private int year;
	private List<CourseSection> enrolledCourses;
	private List<Course> successfulCourses;
	
	private int studentID;
	private String password = "";
	private Transcript transcript;
	private ArrayList<Course> choosableCourses = new ArrayList<Course>();
	private ArrayList<Course> chosenCourses = new ArrayList<Course>();
	private ArrayList<Course> acceptedCourses = new ArrayList<Course>();
	private ArrayList<Course> deniedCourses = new ArrayList<Course>();
	
	
	public Student(String firstName, String lastName, int studentID, String password, Advisor advisor, Transcript transcript) {
		super(firstName, lastName);
        this.studentID = studentID;
        this.password = password;
        this.advisor = advisor;
        this.transcript = transcript;
	        
    }
	 
	public List<Course> viewCourses() {
		return ;
	}
	public String viewSchedule() {
		return "";
	}
	
	
	
	
	
	
	
	public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public ArrayList<Course> getchoosableCourses() {
        return choosableCourses;
    }

    public void setChoosableCourses(ArrayList<Course> choosableCourses) {
        this.choosableCourses = choosableCourses;
    }

    public ArrayList<Course> getchosenCourses() {
        return chosenCourses;
    }

    public void setChosenCourses(ArrayList<Course> chosenCourses) {
        this.chosenCourses = chosenCourses;
    }

    public ArrayList<Course> getAcceptedCourses() {
        return acceptedCourses;
    }

    public void setAcceptedCourses(ArrayList<Course> acceptedCourses) {
        this.acceptedCourses = acceptedCourses;
    }


	public ArrayList<Course> getDeniedCourses() {
		return deniedCourses;
	}


	public void setDeniedCourses(ArrayList<Course> deniedCourses) {
		this.deniedCourses = deniedCourses;
	}


	
	
	
}
