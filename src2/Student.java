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
    private ArrayList<String> unreadNotifications = new ArrayList<String>();
    private ArrayList<String> readNotifications = new ArrayList<String>();
    
    
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
    
//   public boolean isPrerequisiteCoursesPassed(Course course) {	
//    	int temp = 0;
//    	for(int i = 0; i < course.viewPrerequisiteCourses().size(); i++) {
//    		// FD is not a passing grade, however with FD student can take the next course
//    		if (isPassedCourse(course.viewPrerequisiteCourses().get(i)) || course.getCourseLetterGrade().equals("FD")){
//    		temp++;
//    		}
//    	}	
//	    if (temp == course.viewPrerequisiteCourses().size()) {
//	    	return true;
//	    }
//	    else {
//	    	return false;
//	    }
//    }
   
//   public boolean isPassedCourse(Course course) {
//	   if (this.getPassedCourses().contains(course)) {
//           return true;
//       }
//       else  {
//	       return false;
//       }
//   }
   
//   public boolean isFailedCourse(Course course) {
//       for (int i = 0; i < this.getFailedCourses().size(); i++) {
//           if (this.getFailedCourses().get(i).getCourseID().getId().equals(course.getCourseID().getId())) {
//               return true;
//           }
//       }
//       return false;
//   }
   
//   public boolean isCourseTakenBefore(Course course) {
//       for (int i = 0; i < ObjectCreator.courses.size(); i++) {
//           if (isPassedCourse(course) || isFailedCourse(course)) {
//               return true;
//           }
//       }
//       return false;
//   }
   
//   public boolean isChoosableCourse(Course course) {
//	   this.setChoosableCourses();
//       for (int i = 0; i < ObjectCreator.courses.size(); i++) {
//           if (this.getChoosableCourses().contains(course)) {
//               return true;
//           }
//       }
//       return false;
//   }
   
//   public boolean isChosenCourse(CourseSection cs) {
//	   this.setChoosableCourses();
//       for (int i = 0; i < this.chosenCourses.size(); i++) {
//           if (this.getChosenCourses().contains(cs)) {
//               return true;
//           }
//       }
//       return false;
//   }
   
   
   
//   public void addChosenCourse(CourseSection cs) {
//	   
//	   if (isChoosableCourse(cs.getCourse())) {
//	   this.chosenCourses.add(cs);
//	   this.choosableCourses.remove(cs.getCourse());
//	   }
//   }
   
//   public void removeChosenCourse(CourseSection cs) {
//	   
//	   if (isChoosableCourse(cs.getCourse()) && isChosenCourse(cs)) {
//	   this.chosenCourses.remove(cs);
//	   this.choosableCourses.add(cs.getCourse());
//	   } 	   
//   }
  

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
	    this.readNotifications.addAll(unreadNotifications);
	    this.unreadNotifications.clear();
	}
   
   public void sendForApproval() {
	   this.approveRequest = 1;
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



//	public void setChoosableCourses() {
//		choosableCourses = new ArrayList<Course>();
//		for (int i = 0; i < ObjectCreator.courses.size(); i++) {
//			// each course in all courses is evaluated. if one's term is lower than student's and one is in the student's passed courses list
//			if ((ObjectCreator.courses.get(i).getCourseTerm() <= this.getTerm()) && !(this.getPassedCourses().contains(ObjectCreator.courses.get(i)) 
//					&& isPrerequisiteCoursesPassed(ObjectCreator.courses.get(i)))) {
//				// each course in all courses is evaluated. if one's prerequisite is not passed
//				this.choosableCourses.add(ObjectCreator.courses.get(i));
//				}
//			}
//		}
	
   }