import java.util.ArrayList;

public class Transcript extends Student{
	
	private double gpa;
	private double cgpa;
	private int creditReceived;
	private int creditEarned;
	private int totalCreditReceived;
	private int totalCreditEarned;
    private ArrayList<Course> passedCourses;
    private ArrayList<Course> failedCourses;
    private ArrayList<Course> choosableCourses;
	
	public Transcript(ID StudentID) {
		super(StudentID);
	}
	
	public Transcript(ID StudentID, String firstName, String lastName, int term, double gpa,
			double cgpa, int creditReceived, int creditEarned, int totalCreditReceived, 
			int totalCreditEarned, ArrayList<Course> passedCourses, ArrayList<Course> failedCourses) {
		super(StudentID);
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
        System.out.println("Current Term: " + super.getTerm());
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
	
  public boolean isPrerequisiteCoursesPassed(Course course) {	
	int temp = 0;
	for(int i = 0; i < course.viewPrerequisiteCourses().size(); i++) {
		// FD is not a passing grade, however with FD student can take the next course
		if (isPassedCourse(course.viewPrerequisiteCourses().get(i))){
			
		temp++;
		}
	}	
	for(int i = 0; i < this.failedCourses.size(); i++) {
		if(this.failedCourses.get(i).getCourseLetterGrade().equals("FD")) {
			temp++;
		}
	}
	
    if (temp == course.viewPrerequisiteCourses().size()) {
    	return true;
    }
    else {
    	return false;
    }
}
	
  public boolean isPassedCourse(Course course) {
	  for(int i = 0; i < this.passedCourses.size(); i++) {
	  if (this.passedCourses.get(i).getCourseID().getId().equals(course.getCourseID().getId())) {
		   return true;
	  	}
	  }
	  return false;
}
  
  public boolean isFailedCourse(Course course) {
      for (int i = 0; i < this.getFailedCourses().size(); i++) {
          if (this.getFailedCourses().get(i).getCourseID().getId().equals(course.getCourseID().getId())) {
              return true;
          }
      }
      return false;
  }
	
  public boolean isCourseTakenBefore(Course course) {
  for (int i = 0; i < ObjectCreator.courses.size(); i++) {
      if (isPassedCourse(course) || isFailedCourse(course)) {
          return true;
      }
  }
  return false;
}
	
  public boolean isChoosableCourse(Course course) {
	   this.setChoosableCourses();
    for (int i = 0; i < ObjectCreator.courses.size(); i++) {
        if (this.getChoosableCourses().contains(course)) {
            return true;
        }
    }
    return false;
}

public boolean isChosenCourse(CourseSection cs) {
	   this.setChoosableCourses();
    for (int i = 0; i < this.getChosenCourses().size(); i++) {
        if (this.getChosenCourses().contains(cs)) {
            return true;
        }
    }
    return false;
}
	
  public void addChosenCourse(CourseSection cs) {
	   
	   if (isChoosableCourse(cs.getCourse())) {
	   this.getChosenCourses().add(cs);
	   this.choosableCourses.remove(cs.getCourse());
	   }
}

public void removeChosenCourse(CourseSection cs) {
	   
	   if (isChoosableCourse(cs.getCourse()) && isChosenCourse(cs)) {
	   this.getChosenCourses().remove(cs);
	   this.choosableCourses.add(cs.getCourse());
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
		for (int i = 0; i < this.getPassedCourses().size(); i++) {
			System.out.println(this.getPassedCourses().get(i).getCourseName() +
					" - " + this.getPassedCourses().get(i).getCourseLetterGrade());
		}
		
	}
	
	public void viewFailedCourses() {
		System.out.println("Failed Courses: ");
		for (int i = 0; i < this.getFailedCourses().size(); i++) {
			System.out.println(this.getFailedCourses().get(i).getCourseName() +
					" - " + this.getFailedCourses().get(i).getCourseLetterGrade());
			
		}
		
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
	
	public ArrayList<Course> getChoosableCourses() {
		return this.choosableCourses;
	}
	
	public void setChoosableCourses() {
		choosableCourses = new ArrayList<Course>();
		boolean temp = false;
		for (int i = 0; i < ObjectCreator.courses.size(); i++) {
			// each course in all courses is evaluated. if one's term is lower than student's and one is in the student's passed courses list
			if (((ObjectCreator.courses.get(i).getCourseTerm() <= this.getTerm()) && !(isPassedCourse(ObjectCreator.courses.get(i)))
					&& isPrerequisiteCoursesPassed(ObjectCreator.courses.get(i)))) {
				temp = true;
				}
			for (int j = 0; j < this.getFailedCourses().size(); j++)
			if (isFailedCourse(ObjectCreator.courses.get(i)) && this.getFailedCourses().get(j).getCourseLetterGrade().equals("FD")){
				temp = true;
				
			}
				// each course in all courses is evaluated. if one's prerequisite is not passed
				if (temp == true) {
				this.choosableCourses.add(ObjectCreator.courses.get(i));
					}
				temp = false;
				}
			}
		

}