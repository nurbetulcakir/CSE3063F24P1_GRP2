import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SessionTime extends CourseSection {
    // Attributes
    private String startDateTime;
    private String endDateTime;
    private String classroom;

    // Constructor    
    public SessionTime(int sectionID, Course course, int capacity, String startDateTime, String endDateTime, String classroom) {
        super(sectionID, course, capacity);
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.classroom = classroom;
    }

    // Method to check if the session time is valid
    public boolean isValidSession() {
        // Checks if startDateTime is before endDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime start = LocalDateTime.parse(this.startDateTime, formatter);
        LocalDateTime end = LocalDateTime.parse(this.endDateTime, formatter);

        return start.isBefore(end); // Return true if start time is before end time
    }

    // Getters and Setters
    public String getStartTime() {
        return this.startDateTime;
    }

    public String getEndTime() {
        return this.endDateTime;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
