import java.util.Scanner;

public class StudentInterface {

	public void run() {
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
			    System.out.println("Welcome to Information Management System! What would you like to do?");
			    System.out.println("1. View schedule");
			    System.out.println("2. View transcript");
			    System.out.println("3. View advisor information");
			    System.out.println("4. Register for the current term");
			    System.out.println("5. Send courses for approval");
			    System.out.println("6. View notifications");
			    System.out.println("7. Logout");
			    System.out.print("Please type the number of your selection: ");
			    
			    int choice = scanner.nextInt(); 
			    scanner.nextLine();

            switch (choice) {
                case 1:
                	// not finished
                	ObjectCreator.students.get(UserInterface.currentStudentsIndex).viewSchedule();
                    break;
                case 2:
                	ObjectCreator.transcripts.get(UserInterface.currentTranscriptsIndex).viewTranscript();
                	
                	
                    break;
                case 3:
                	for(int i = 0; i < ObjectCreator.advisors.size(); i++) {
                		if (ObjectCreator.advisors.get(i).getLecturerID().getId().equals(ObjectCreator.students.get(UserInterface.currentStudentsIndex).getAdvisor().getLecturerID().getId())) {
            	    		UserInterface.currentAdvisorsIndex = i;
                		}
                	}
                	Advisor advisor = ObjectCreator.advisors.get(UserInterface.currentAdvisorsIndex);
            		String courseId;
            	    String courseName;
            	    int courseTerm ;
            	    double courseCredit;
            	    		System.out.println("\nAdvisor Information for Student: " + ObjectCreator.students.get(UserInterface.currentStudentsIndex).getFirstName()
            	    				+ " " + ObjectCreator.students.get(UserInterface.currentStudentsIndex).getLastName() + ".\n");
            	    		System.out.println("ID: " + advisor.getLecturerID().getId());
            				System.out.println("First Name:" + advisor.getFirstName());
            				System.out.println("Last Name:" + advisor.getLastName());
            				System.out.println();
            				System.out.println("Given Courses: ");
            				System.out.printf("%-10s %-60s %-20s %-10s%n", "Course ID", "Course Name", "Course Term", "Course Credit");
            		        System.out.println("---------------------------------------------------------------"
            		        		+ "---------------------------------------------------------------");
            				for(int j = 0; j < advisor.getGivenCourses().size(); j++) {
            					courseId = advisor.getGivenCourses().get(j).getCourseID().getId();
            				    courseName = advisor.getGivenCourses().get(j).getCourseName();
            				    courseTerm = advisor.getGivenCourses().get(j).getCourseTerm();
            				    courseCredit = advisor.getGivenCourses().get(j).getCourseCredit();

            				    System.out.printf("%-10s %-60s %-20d %-10.1f%n", courseId, courseName, courseTerm, courseCredit);
            					
            					}
            				System.out.println();
            				
            			    System.out.print("If you want to go back main menu, please insert 1: ");
            			    int outChoice = scanner.nextInt(); 
            			    scanner.nextLine();
            			    if (outChoice == 1) {
            			    	break;
            			    }else {
            			    	System.out.print("Invalid input, Please insert 1 to go back to main menu");
                			    int outChoice2 = scanner.nextInt(); 
                			    scanner.nextLine();
            			    	if (outChoice2 == 1) {
            			    		break;
            			    	}
            			    }
            			    
                    break;
                case 4:
                	ObjectCreator.transcripts.get(UserInterface.currentTranscriptsIndex).setChoosableCourses();
                	boolean loopController = true;
                	while(loopController) {
                	System.out.println("Choosable Courses:");
                    Transcript currentTranscript = ObjectCreator.transcripts.get(UserInterface.currentTranscriptsIndex);

                    for (int i = 0; i < currentTranscript.getChoosableCourses().size(); i++) {
                        System.out.println((i + 1) + ". " + currentTranscript.getChoosableCourses().get(i).getCourseName());
                    }
                    System.out.println((currentTranscript.getChoosableCourses().size() + 1) + ". Main Menu");

                    System.out.print("Please select a course to register (type the number): ");
                    int courseChoice = scanner.nextInt();
                    scanner.nextLine();

                    // Go back option
                    if (courseChoice == currentTranscript.getChoosableCourses().size() + 1) {
                    	break;
                    }
                    if (courseChoice > 0 && courseChoice <= currentTranscript.getChoosableCourses().size()) {
                        Course selectedCourse = currentTranscript.getChoosableCourses().get(courseChoice - 1);

                        // Display available sections for the selected course
                        System.out.println("Available Sections for " + selectedCourse.getCourseName() + ":");
                        
                        CourseSection section = null;
                        //burdan sonrası
                        for(int i = 0; i < ObjectCreator.courseSections.size(); i++) {
                        	if(ObjectCreator.courseSections.get(i).getCourse().getCourseID().getId().equals(selectedCourse.getCourseID().getId())) {
                        		section = ObjectCreator.courseSections.get(i);
                        	}
                        }
                        for (int i = 0; i < section.getCourseSessions().size(); i++) {
                            System.out.println((i + 1) + ". Section " + section.getSectionID() + " | Capacity: " +
                                    section.getCapacity());
                        }
                        System.out.println((section.getCourseSessions().size() + 1) + ". Main Menu");
                        System.out.print("Please select a section to register (type the number): ");
                        int sectionChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        
                        // Main Menu
                        if (sectionChoice == section.getCourseSessions().size() + 1) {
                            break;
                        }
                        
                        if (sectionChoice > 0 && sectionChoice <= section.getCourseSessions().size()) {
                            CourseSection selectedSection = section.getCourseSessions().get(sectionChoice - 1);

                           // Register for the chosen section
                           ObjectCreator.transcripts.get(UserInterface.currentTranscriptsIndex).addChosenCourse(selectedSection);
                           ObjectCreator.transcripts.get(UserInterface.currentTranscriptsIndex).getChoosableCourses().remove(selectedCourse);
                           
                                System.out.println("Successfully registered for " + selectedCourse.getCourseName() +
                                        " (Section " + (selectedSection.getSectionID() + 1) + ").");
                        } else {
                            System.out.println("Invalid section choice.");
                            break;
                        }
                    }
                    else {
                        System.out.println("Invalid course choice.");
                        break;
                    	}
                	}
                    break;

                case 5:
                	ObjectCreator.students.get(UserInterface.currentStudentsIndex).sendForApproval();
                    break;
                case 6:
                	/* VIEW NOTIFICATIONS */
                	break;
                case 7:
                	System.out.println("Logging out...");
                	UserInterface.userIdInput = "";
                	UserInterface.passwordInput = "";
                	UserInterface.currentStudentsIndex = 999;
                	UserInterface.currentTranscriptsIndex = 999;
                	UserInterface.currentAdvisorsIndex = 999;
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
      }
	}
	
//	public boolean chooseCourse(Student student, CourseSection courseSection) {
//		// Check prerequisites
//		if (!student.isPrerequisiteCoursesPassed(courseSection.getCourse())) {
//			return false;
//		}
//	
//		// Check course capacity
//		if (courseSection.getCapacity() <= 0) {
//			return false;
//		}
//	
//		// Check if the student is already enrolled in this course section
//		if (student.getChosenCourses().contains(courseSection)) {
//			return false;
//		}
//		// Check if the student's term matches the course term
//		if (student.getTerm() < courseSection.getCourse().getCourseTerm()) {
//			return false;
//		}
//		// Check if the student has reached the maximum number of courses
//		if (student.getChosenCourses().size() >= 5) {
//			return false;
//		}
//	
//		student.getChosenCourses().add(courseSection);
//		courseSection.getEnrolledStudents().add(student);
//		courseSection.setCapacity(courseSection.getCapacity() - 1);
//		return true;
//	}
	
	public boolean dropCourse(Student student, CourseSection courseSection) {
		// Check if the student is enrolled in the course section
		if (!student.getChosenCourses().contains(courseSection)) {
			return false;
		}
	
		courseSection.getEnrolledStudents().remove(student);
		student.getChosenCourses().remove(courseSection);
		// Increase the capacity by 1 as the student is now unenrolled
		courseSection.setCapacity(courseSection.getCapacity() + 1);
	
		return true;
	}
}
