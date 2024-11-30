import java.util.ArrayList;

public class Transcript extends Student{
	
	private double gpa;
	private double cgpa;
	private int creditReceived;
	private int creditEarned;
	private int totalCreditReceived;
	private int totalCreditEarned;
	
	public Transcript(ID StudentID) {
		super(StudentID);
	}
	
	public Transcript(ID StudentID, String firstName, String lastName, int term, double gpa,
			double cgpa, int creditReceived, int creditEarned, int totalCreditReceived, 
			int totalCreditEarned, ArrayList<Course> passedCourses, ArrayList<Course> failedCourses) {
		
		super(StudentID);
		this.getTerm();
		this.setGpa(gpa);
		this.setCpga(cgpa);
		this.setCreditReceived(creditReceived);
		this.setCreditEarned(creditEarned);
		this.setCreditReceived(totalCreditReceived);
		this.setTotalCreditEarned(totalCreditEarned);
		this.setPassedCourses(passedCourses);
		this.setFailedCourses(failedCourses);
		}
	
	public void viewTranscript() {
		System.out.println("Transcript Details:");
        System.out.println("Student ID: " + this.getStudentID().getId());
        System.out.println("Current Term: " + this.getTerm());
        System.out.println("First Name: " + this.getFirstName());
        System.out.println("Last Name: " + this.getLastName());
        System.out.println("GPA: " + gpa);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Credits Received: " + creditReceived);
        System.out.println("Credits Earned: " + creditEarned);
        System.out.println();
        System.out.println("Passed Courses: ");
        for(int i=0; i<this.getPassedCourses().size(); i++) {
        	System.out.println("Course ID: " + this.getPassedCourses().get(i).getCourseID().getId());
        	System.out.println("Course Name: " + this.getPassedCourses().get(i).getCourseName());
        	System.out.println("Final Letter Grade: " + this.getPassedCourses().get(i).getCourseLetterGrade());
        	System.out.println();
		}
        for(int i=0; i<this.getFailedCourses().size(); i++) {
        	System.out.println("Course ID: " + this.getFailedCourses().get(i).getCourseID().getId());
        	System.out.println("Course Name: " + this.getFailedCourses().get(i).getCourseName());
        	System.out.println("Final Letter Grade: " + this.getFailedCourses().get(i).getCourseLetterGrade());
        	System.out.println();
		}
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCpga(double cgpa) {
		this.cgpa = cgpa;
	}

	public int getCreditReceived() {
		return creditReceived;
	}

	public void setCreditReceived(int creditReceived) {
		this.creditReceived = creditReceived;
	}

	public int getCreditEarned() {
		return creditEarned;
	}

	public void setCreditEarned(int creditEarned) {
		this.creditEarned = creditEarned;
	}

	public int getTotalCreditReceived() {
		return totalCreditReceived;
	}

	public void setTotalCreditReceived(int totalCreditReceived) {
		this.totalCreditReceived = totalCreditReceived;
	}

	public int getTotalCreditEarned() {
		return totalCreditEarned;
	}

	public void setTotalCreditEarned(int totalCreditEarned) {
		this.totalCreditEarned = totalCreditEarned;
	}
	
	public void viewSuccessfulCourses() {
		System.out.println("Succesful Courses: ");
		for (int i = 0; i < super.getPassedCourses().size(); i++) {
			System.out.println(super.getPassedCourses().get(i).getCourseName() +
					" - " + super.getPassedCourses().get(i).getCourseLetterGrade());
		}
		
	}
	
	public void viewFailedCourses() {
		System.out.println("Failed Courses: ");
		for (int i = 0; i < super.getFailedCourses().size(); i++) {
			System.out.println(super.getFailedCourses().get(i).getCourseName() +
					" - " + super.getFailedCourses().get(i).getCourseLetterGrade());
			
		}
		
	}

}