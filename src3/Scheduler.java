import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Scheduler {

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

    public boolean scheduleCourse(CourseSection courseSection, ScheduleData.Day day, ScheduleData.StartTime startTime,
                                  ScheduleData.Classroom classroom) {
        // Check if the time slot is available
        if (scheduleMap.get(day).get(startTime) != null) {
            System.out.println("Time slot is already occupied.");
            return false;
        }

        // Check if the classroom is available
        if (!availableClassrooms.contains(classroom)) {
            System.out.println("Classroom is not available.");
            return false;
        }

        // Assign course to schedule
        scheduleMap.get(day).put(startTime, courseSection);
        availableClassrooms.remove(classroom); // Mark classroom as occupied
        System.out.println("Scheduled " + courseSection.getCourse().getCourseName() + " on " + day + " at " +
                startTime + " in " + classroom + ".");
        return true;
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
}
