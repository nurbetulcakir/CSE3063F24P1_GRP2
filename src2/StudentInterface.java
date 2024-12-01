import java.util.ArrayList;
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
			    
			    Student currentStudent = ObjectCreator.students.get(UserInterface.currentStudentsIndex);
                Transcript currentTranscript = ObjectCreator.transcripts.get(UserInterface.currentTranscriptsIndex);
			    
			    int choice = scanner.nextInt(); 
			    scanner.nextLine();

            switch (choice) {
                case 1:
                	// not finished
                	ObjectCreator.students.get(UserInterface.currentStudentsIndex).viewSchedule();
                	
                    break;
                    
                case 2:
                	Transcript transcript = ObjectCreator.transcripts.get(UserInterface.currentTranscriptsIndex);
                	
            		System.out.println("Transcript Details:");
                    System.out.println("Student ID: " + transcript.getStudentID().getId());
                    System.out.println("Current Term: " + transcript.getTerm());
                    System.out.println("First Name: " + transcript.getFirstName());
                    System.out.println("Last Name: " + transcript.getLastName());
                    System.out.println("GPA: " + transcript.getGpa());
                    System.out.println("CGPA: " + transcript.getCgpa());
                    System.out.println("Credits Received: " + transcript.getCreditReceived());
                    System.out.println("Credits Earned: " + transcript.getCreditEarned());
                    System.out.println();
                    System.out.println("Passed Courses: ");
                    for(int i=0; i<transcript.getPassedCourses().size(); i++) {
                    	System.out.println("Course ID: " + transcript.getPassedCourses().get(i).getCourseID().getId());
                    	System.out.println("Course Name: " + transcript.getPassedCourses().get(i).getCourseName());
                    	System.out.println("Final Letter Grade: " + transcript.getPassedCourses().get(i).getCourseLetterGrade());
                    	System.out.println("------------------------------------------");
            		}
                    System.out.println("Failed Courses: ");
                    if (transcript.getFailedCourses().size() > 0) {
                    for(int i=0; i<transcript.getFailedCourses().size(); i++) {
                    	System.out.println("Course ID: " + transcript.getFailedCourses().get(i).getCourseID().getId());
                    	System.out.println("Course Name: " + transcript.getFailedCourses().get(i).getCourseName());
                    	System.out.println("Final Letter Grade: " + transcript.getFailedCourses().get(i).getCourseLetterGrade());
                    	System.out.println("------------------------------------------");
            			}
                    }
                    else {
                    	System.out.println("There is no failed course!");
                    }
    			    System.out.print("If you want to go back main menu, please insert 1: ");
    			    int outChoiceTC = scanner.nextInt(); 
    			    scanner.nextLine();
    			    if (outChoiceTC == 1) {
    			    	break;
    			    }else {
    			    	System.out.println("Invalid input. Turning back to main menu...");
    			    }
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
                	currentTranscript.setChoosableCourses();
                	boolean loopController = true;
                	currentTranscript.setChosenCourses(new ArrayList<CourseSection>());
                	CourseSection selectedSection;
                	while(loopController) {
                	System.out.println("Choosable Courses:");
                    CourseSection section = new CourseSection();

                    
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
                        
                        for(int i = 0; i < ObjectCreator.courseSections.size(); i++) {
                        	if(ObjectCreator.courseSections.get(i).getCourse().getCourseID().getId().equals(selectedCourse.getCourseID().getId())) {
                        		section = ObjectCreator.courseSections.get(i);
                        		selectedCourse.getCourseSections().add(section);
                        	}
                        }
                        
                        for (int j = 0; j < selectedCourse.getCourseSections().size(); j++) {
                            System.out.println((j + 1) + ". Section " + selectedCourse.getCourseSections().get(j).getSectionID() + " | Capacity: " + selectedCourse.getCourseSections().get(j).getCapacity());
                        }

                        System.out.println((selectedCourse.getCourseSections().size() + 1) + ". Main Menu");
                        System.out.print("Please select a section to register (type the number): ");
                        int sectionChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        
                        // Main Menu
                        if (sectionChoice == section.getCourseSessions().size() + 1) {
                            break;
                        }
                        
                        if (sectionChoice > 0 && sectionChoice <= selectedCourse.getCourseSections().size()) {
                            selectedSection = selectedCourse.getCourseSections().get(sectionChoice - 1);

                           // Register for the chosen section
                           currentTranscript.getChosenCourses().add(selectedSection);
                           currentTranscript.getChoosableCourses().remove(selectedCourse);
                           
                                System.out.println("Successfully registered for " + selectedCourse.getCourseName() +
                                        " (Section " + selectedSection.getSectionID() + ").");
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
                    CourseSection chosenSection = new CourseSection();
                    if (currentTranscript.getChosenCourses() == null) {
                        System.out.println("You have no chosen courses to send for approval. Please register for courses first from menu(4).");
                        break;
                    }

                    System.out.println("The following courses will be sent to your advisor for approval:");
                    for (int i = 0; i < currentTranscript.getChosenCourses().size(); i++) {
                    	chosenSection = currentTranscript.getChosenCourses().get(i);
                        System.out.println((i + 1) + ". " + chosenSection.getCourse().getCourseName() + " - Section " + chosenSection.getSectionID());
                    	
                    }

                    System.out.print("Do you confirm to send for approval? (Y/N) ");
                    String approvalChoice = scanner.nextLine();

                    if (approvalChoice.equalsIgnoreCase("Y")) { // "y" and "Y" accepted

                        currentStudent.sendForApproval(); // Assuming this method sends the courses to the advisor

                        
                        System.out.println("Your selected courses have been successfully sent for approval.");
                        System.out.print("Do you want to exit to main menu? (Y/N) ");
                        String successOut = scanner.nextLine();
                        if (successOut.equalsIgnoreCase("Y")) {
                        	break;
                        } else if (successOut.equalsIgnoreCase("N")) {
                        	System.out.println("Not exited to main menu, when you want to exit please press 'Y'. ");
                            successOut = scanner.nextLine();
                            if (successOut.equalsIgnoreCase("Y")) {
                            	break;
                            }
                        } else {
                        	System.out.println("Invalid input. Returning to main menu...");
                        	
                        }
                    } else if (approvalChoice.equalsIgnoreCase("N")) {
                        System.out.println("Course approval send canceled.");
                    } else {
                        System.out.println("Invalid input. Returning to main menu.");
                    }
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
}
