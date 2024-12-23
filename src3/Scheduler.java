import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Scheduler {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	private String id = "20242212";
	private String password = "Nightrein2077";
	ScheduleData.Day day;
	ScheduleData.StartTime startTime;
	ScheduleData.Classroom classroom;
	static int currentSectionIndex;

    // Data Structures
    private Map<ScheduleData.Day, Map<ScheduleData.StartTime, CourseSection>> scheduleMap;
    private ArrayList<ScheduleData.Classroom> availableClassrooms;

    // Constructor
    public Scheduler() {
        this.scheduleMap = new HashMap<>();
        this.availableClassrooms = new ArrayList<>();

        // Initialize classrooms
        for (ScheduleData.Classroom classroom : ScheduleData.Classroom.values()) {
            availableClassrooms.add(classroom);
        }

        // Initialize scheduleMap for each day and start time
        for (ScheduleData.Day day : ScheduleData.Day.values()) {
            scheduleMap.put(day, new HashMap<>());
            for (ScheduleData.StartTime startTime : ScheduleData.StartTime.values()) {
                scheduleMap.get(day).put(startTime, null); // Initially, no courses are assigned
            }
        }
    }

    // Main method to run the Scheduler Interface
    public void run() {
        while (true) {
            displayMenu();
            int choice = getUserInput();

            switch (choice) {
                case 1:
                	scheduleCourse();
                    ;
                    break;
                case 2:
                	displaySchedule()
                    ;
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return; // Logout
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Display the Advisor menu
    private void displayMenu() {
        System.out.println("\n=== Schedule Menu ===");
        System.out.println("1. Schedule Course");
        System.out.println("2. Display Schedule");
        System.out.println("3. Logout");
        System.out.print("Please select an option: ");
    }
    
    private int getUserInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        return choice;
    }

    public void scheduleCourse() {
    	while(true) {
	    	System.out.println("Please enter the section id for scheduling Course:");
	    	String id;
	    	id = scanner.nextLine(); 
	    	boolean sectionFound = false;
	    	for (int i = 0;i < ObjectCreator.courseSections.size();i++) {
	    		
	    		if (ObjectCreator.courseSections.get(i).equals(id) ) {
	    			System.out.println("selected course and section:" + ObjectCreator.courseSections.get(i).getCourseName() + " " + id.charAt(id.length() - 1));
	    			sectionFound = true;
	    			currentSectionIndex = i;
	    		}
	    		
	    	}
	    	if (sectionFound == false) {
	    		
	    		System.out.println("You entered wrong or invalid section number.Please try again.");
	    		break;
	    		
	    	} //no loop here. do later !!!!!!!
	    	
	    	System.out.println("Please enter date id time scheduling Course:\nDay:");
	    	
	    	try {
	    		day = ScheduleData.Day.valueOf(scanner.nextLine().toUpperCase()); 
	    	    System.out.println("selected day: " + day);
	    	} catch (IllegalArgumentException e) {
	    	    System.out.println("you entered invalid day. Please try again.");
	    	}
	    	
	    	
	    	System.out.println("Time:");
	    	try {
	    		startTime = ScheduleData.StartTime.valueOf(scanner.nextLine().toUpperCase()); 
	    	    System.out.println("selected time: " + startTime);
	    	} catch (IllegalArgumentException e) {
	    	    System.out.println("you entered invalid time. Please try again.");
	    	}
	    	
	    	
	    	
	        // Check if the time slot is available
	        if (scheduleMap.get(day).get(startTime) != null) {
	            System.out.println("Time slot is already occupied.");
	        }
	        System.out.println("Please enter classroom for scheduling Course:");
	        try {
	        	classroom = ScheduleData.Classroom.valueOf(scanner.nextLine().toUpperCase()); 
	    	    System.out.println("selected day: " + day);
	    	} catch (IllegalArgumentException e) {
	    	    System.out.println("you entered invalid classroom. Please try again.");
	    	}
	        
	        
	        // Check if the classroom is available
	        if (!availableClassrooms.contains(classroom)) {
	            System.out.println("Classroom is not available.");
	        }
	        
	        CourseSection courseSection = new CourseSection(ObjectCreator.courseSections.get(currentSectionIndex).getSectionID(),ObjectCreator.courseSections.get(currentSectionIndex),30);
	
	        // Assign course to schedule
	        scheduleMap.get(day).put(startTime, courseSection);
	        availableClassrooms.remove(classroom); // Mark classroom as occupied
	        System.out.println("Scheduled " + courseSection.getCourse().getCourseName() + " on " + day + " at " + startTime + " in " + classroom + ".");
	        break;
	    }
    }

    public boolean freeTimeSlot(ScheduleData.Day day, ScheduleData.StartTime startTime,
                                ScheduleData.Classroom classroom) {
        if (scheduleMap.get(day).get(startTime) == null) {
            System.out.println("Time slot is already free.");
            return false;
        }

        scheduleMap.get(day).put(startTime, null); // Remove the course from the schedule
        if (!availableClassrooms.contains(classroom)) {
            availableClassrooms.add(classroom); // Mark classroom as available
        }
        System.out.println("Time slot on " + day + " at " + startTime + " in " + classroom + " is now free.");
        return true;
    }


    public void displaySchedule() {
        System.out.println("Current Schedule:");
        for (ScheduleData.Day day : ScheduleData.Day.values()) {
            System.out.println(day + ":");
            for (Map.Entry<ScheduleData.StartTime, CourseSection> entry : scheduleMap.get(day).entrySet()) {
                ScheduleData.StartTime startTime = entry.getKey();
                CourseSection courseSection = entry.getValue();
                if (courseSection != null) {
                    System.out.println("  " + startTime + " - " + courseSection.getCourse().getCourseName());
                } else {
                    System.out.println("  " + startTime + " - Free");
                }
            }
        }
    }

    public ArrayList<ScheduleData.Classroom> getAvailableClassrooms() {
        return new ArrayList<>(availableClassrooms); // Return a copy to maintain encapsulation
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
