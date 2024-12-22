import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Scheduler {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	private String id = "20242212";
	private String password = "Nightrein2077";

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
    	
    	System.out.println("Please enter the section id for scheduling Course:");//içi yapılmadı
    	System.out.println("Please enter date id time scheduling Course:\nDay:");
    	ScheduleData.Day day = scanner.nextLine();
    	System.out.println("Time:");
    	ScheduleData.StartTime startTime = scanner.nextLine();
        // Check if the time slot is available
        if (scheduleMap.get(day).get(startTime) != null) {
            System.out.println("Time slot is already occupied.");
        }
        System.out.println("Please enter classroom for scheduling Course:");
        ScheduleData.Classroom classroom = scanner.nextLine();
        // Check if the classroom is available
        if (!availableClassrooms.contains(classroom)) {
            System.out.println("Classroom is not available.");
        }

        // Assign course to schedule
        scheduleMap.get(day).put(startTime, courseSection);
        availableClassrooms.remove(classroom); // Mark classroom as occupied
        System.out.println("Scheduled " + courseSection.getCourse().getCourseName() + " on " + day + " at " + startTime + " in " + classroom + ".");
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
