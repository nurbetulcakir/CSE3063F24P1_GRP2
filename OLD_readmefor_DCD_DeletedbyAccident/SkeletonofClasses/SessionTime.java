import java.time.LocalDateTime;

public class SessionTime {
    // Attributes
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String classroom;

    // Constructor
    public SessionTime(LocalDateTime startDateTime, LocalDateTime endDateTime, String classroom) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.classroom = classroom;
    }

    // Method to check if the session time is valid
    public boolean isValidSession() {
        // Checks if startDateTime is before endDateTime
        return startDateTime.isBefore(endDateTime);
    }

    // Getters and Setters
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
