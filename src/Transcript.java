import java.util.ArrayList;

public class Transcript extends Student{
	
	private double gpa;
	private double cpga;
	private int creditReceived;
	private int creditEarned;
	private int totalCreditReceived;
	private int totalCreditEarned;
	
	public Transcript(ID StudentID, String firstName, String lastName, double gpa,
			double cpga, int creditReceived, int creditEarned, int totalCreditReceived,
			int totalCreditEarned, ArrayList<Course> passedCourses) {
		
		super(StudentID, firstName, lastName);
		this.setGpa(gpa);
		this.setCpga(cpga);
		this.setCreditReceived(creditReceived);
		this.setCreditEarned(creditEarned);
		this.setTotalCreditReceived(totalCreditReceived);
		this.setTotalCreditEarned(totalCreditEarned);
		this.setPassedCourses(passedCourses);
		
		
	}
	
	public Transcript(ID StudentID, String firstName, String lastName, double gpa,
			double cpga, int creditReceived, int creditEarned, ArrayList<Course> passedCourses, ArrayList<String> courseLetterGrade) {
		
		super(StudentID, firstName, lastName);
		this.setGpa(gpa);
		this.setCpga(cpga);
		this.setCreditReceived(creditReceived);
		this.setCreditEarned(creditEarned);
		super.setPassedCourses(passedCourses);
		for(int i=0; i<super.getPassedCourses().size(); i++) {
			super.getPassedCourses().get(i).setCourseLetterGrade(courseLetterGrade.get(i));
		}
		
	}
	
	
	public void viewTranscript() {
		System.out.println("Transcript Details:");
        System.out.println("Student ID: " + super.getStudentID());
        System.out.println("Current Term: " + super.getTerm());
        System.out.println("First Name: " + super.getFirstName());
        System.out.println("Last Name: " + super.getLastName());
        System.out.println("GPA: " + gpa);
        System.out.println("CGPA: " + cpga);
        System.out.println("Credits Received: " + creditReceived);
        System.out.println("Credits Earned: " + creditEarned);
        System.out.println("Passed Courses: ");
        for(int i=0; i<super.getPassedCourses().size(); i++) {
        	System.out.println("Course ID: " + super.getPassedCourses().get(i).getCourseID().getId());
        	System.out.println("Course Name: " + super.getPassedCourses().get(i).getCourseName());
        	System.out.println("Final Letter Grade: " + super.getPassedCourses().get(i).getCourseLetterGrade());
        	System.out.println();
		}
	}
	
	

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public double getCpga() {
		return cpga;
	}

	public void setCpga(double cpga) {
		this.cpga = cpga;
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