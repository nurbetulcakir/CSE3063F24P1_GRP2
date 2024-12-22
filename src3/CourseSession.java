public class CourseSession extends CourseSection {

    // Attributes
    private String day;        // Day of the session (e.g., Monday)
    private String startTime;  // Start time of the session (e.g., "09:00")
    private String endTime;    // End time of the session (e.g., "10:30")
    private String classroom;  // Classroom where the session is held

    // Constructor for creating a course session with all details
    public CourseSession(int sectionID, Course course, int capacity, String day, String startTime, String endTime, String classroom) {
        super(sectionID, course, capacity);
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.classroom = classroom;
    }

    // Constructor for creating a course session without linking to a course section
    public CourseSession(String day, String startTime, String endTime, String classroom) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.classroom = classroom;
    }

    // Method to check if the session's time is valid
    public boolean isValidSession() {
        // Checks if the start time is before the end time
        if (startTime == null || endTime == null) {
            System.out.println("Start time or end time is not set.");
            return false;
        }
        return startTime.compareTo(endTime) < 0;
    }

    // Getters and Setters
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    // Method to display session details
    public void displaySessionDetails() {
        System.out.println("Day: " + day);
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);
        System.out.println("Classroom: " + classroom);
    }
}
