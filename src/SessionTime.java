import java.time.LocalDateTime;

public class SessionTime extends CourseSection{
    // Attributes
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String classroom;

    // Constructor    
    public SessionTime(int capacity, Course course, int capacity1, LocalDateTime startDateTime, LocalDateTime endDateTime, String classroom) {
    	super(capacity1, course, capacity1);
    	this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.classroom = classroom;
    }

    // Method to check if the session time is valid
    public boolean isValidSession() {
        // Checks if startDateTime is before endDateTime
        return startDateTime.isBefore(endDateTime);
    }
    
    public LocalDateTime getStartTime() {
    	return this.startDateTime;
    }
    
    public LocalDateTime getEndTime() {
    	return this.endDateTime;
    }
    

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

}